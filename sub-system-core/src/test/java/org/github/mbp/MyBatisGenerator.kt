package org.github.mbp

import cn.hutool.core.io.FileUtil.*
import cn.hutool.core.util.StrUtil.toCamelCase
import cn.hutool.db.Db.use
import cn.hutool.db.Entity.create
import cn.hutool.db.ds.simple.SimpleDataSource
import cn.hutool.extra.template.TemplateEngine
import cn.hutool.extra.template.TemplateUtil
import com.baomidou.mybatisplus.annotation.FieldFill.INSERT
import com.baomidou.mybatisplus.annotation.FieldFill.INSERT_UPDATE
import com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID
import com.baomidou.mybatisplus.generator.FastAutoGenerator
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.OutputFile.*
import com.baomidou.mybatisplus.generator.config.TemplateType.CONTROLLER
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import com.baomidou.mybatisplus.generator.fill.Column
import org.github.base.Entity
import org.github.base.IMapper
import org.github.base.IService
import org.github.base.ServiceImpl
import java.lang.System.getProperty
import kotlin.reflect.jvm.jvmName

fun main() {
  mysqlMydb()
  mysqlSccore()
}

fun mysqlMydb() {
  val url = "jdbc:mysql://frp:3306/mydb"
  val username = "root"
  val password = "XLrootJYD713"
  val enableKotlin = true
  val dataSourceBuilder = DataSourceConfig.Builder(url, username, password)

  val generator: FastAutoGenerator = FastAutoGenerator.create(dataSourceBuilder)

  generator.globalConfig {it: GlobalConfig.Builder ->
    it.author("JYD_XL")
      .disableOpenDir()
    if (enableKotlin) it.enableKotlin()
  }

  val parent = "org.github.mysql.mydb"
  val moduleName = "base"
  val subName = "sub-mysql-mydb"
  val subEntityName = "$subName-entity"
  val subMapperName = "$subName-service"
  val packageName = parent.replace('.', '/')
  val path = "${getProperty("user.dir")}/"

  del("$path/$subEntityName/src/main/java/$packageName/$moduleName")
  del("$path/$subMapperName/src/main/java/$packageName/$moduleName")
  del("$path/$subMapperName/src/main/resources/mapper")
  generator.packageConfig {it: PackageConfig.Builder ->
    it.parent(parent)
      .moduleName(moduleName)
      .pathInfo(
        mapOf(
          entity to "$path/$subEntityName/src/main/java/$packageName/$moduleName/entity",

          controller to "$path/$subMapperName/src/main/java/$packageName/$moduleName/controller",
          mapper to "$path/$subMapperName/src/main/java/$packageName/$moduleName/mapper",
          service to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service",
          serviceImpl to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service/impl",

          xml to "$path/$subMapperName/src/main/resources/mapper"
        )
      )
  }

  generator.strategyConfig {it: StrategyConfig.Builder ->
    it.addExclude("undo_log")
      .entityBuilder()
      .enableColumnConstant()
      .enableLombok()
      .enableTableFieldAnnotation()
      .enableChainModel()
      .versionColumnName("version")
      .addTableFills(
        listOf(
          Column("created_at", INSERT),
          Column("creator_id", INSERT),
          Column("updated_at", INSERT_UPDATE),
          Column("updater_id", INSERT_UPDATE)
        )
      )
      .idType(ASSIGN_ID)
      // .enableActiveRecord().superClass(Model::class.jvmName)
      .superClass(Entity::class.jvmName)
      .formatFileName("%sEntity")

      .mapperBuilder()
      .superClass(IMapper::class.jvmName)
      .formatMapperFileName("I%sMapper")

      .serviceBuilder()
      .superServiceClass(IService::class.jvmName)
      .formatServiceFileName("I%sService")
      .superServiceImplClass(ServiceImpl::class.jvmName)
      .formatServiceImplFileName("%sServiceImpl")
  }

  generator.templateConfig {it: TemplateConfig.Builder ->
    it.disable(CONTROLLER)
      .entity("/entity.java")
      .entityKt("/entity.kt")
      .mapper("/mapper.java")
      .service("/service.java")
      .serviceImpl("/serviceImpl.java")
  }

  generator.templateEngine(FreemarkerTemplateEngine())
  generator.execute()

  //重新生成枚举
  del("$path/$subEntityName/src/main/java/$packageName/$moduleName/dict")
  val ds = SimpleDataSource(url, username, password)

  val list: MutableList<Item> = use(ds).findAll(create("sys_dict_item"), Item::class.java)
  val engine: TemplateEngine = TemplateUtil.createEngine()
  val map: Map<String, List<Item>> = list.groupBy(Item::dictName)
  map.forEach {(dictName, list) ->
    val name = toCamelCase(dictName).replaceFirstChar {it.uppercase()}
    val params = mapOf(
      "name" to name,
      "list" to list,
      "pack" to "$packageName/$moduleName/dict".replace('/', '.')
    )
    val fileName = if (enableKotlin) "$name.kt" else "$name.java"
    val template = if (enableKotlin) "enum.kt.ftl" else "enum.java.ftl"
    val content: String = engine.getTemplate(readUtf8String(template)).render(params)
    writeUtf8String(content, "$path/$subEntityName/src/main/java/$packageName/$moduleName/dict/$fileName")
  }
}

fun mysqlSccore() {
  val url = "jdbc:mysql://frp:3306/sc_core"
  val username = "root"
  val password = "XLrootJYD713"
  val enableKotlin = true
  val dataSourceBuilder = DataSourceConfig.Builder(url, username, password)

  val generator: FastAutoGenerator = FastAutoGenerator.create(dataSourceBuilder)

  generator.globalConfig {it: GlobalConfig.Builder ->
    it.author("JYD_XL")
      .disableOpenDir()
    if (enableKotlin) it.enableKotlin()
  }

  val parent = "org.github.mysql.sccore"
  val moduleName = "base"
  val subName = "sub-mysql-sccore"
  val subEntityName = "$subName-entity"
  val subMapperName = "$subName-service"
  val packageName = parent.replace('.', '/')
  val path = "${getProperty("user.dir")}/"

  del("$path/$subEntityName/src/main/java/$packageName/$moduleName")
  del("$path/$subMapperName/src/main/java/$packageName/$moduleName")
  del("$path/$subMapperName/src/main/resources/mapper")
  generator.packageConfig {it: PackageConfig.Builder ->
    it.parent(parent)
      .moduleName(moduleName)
      .pathInfo(
        mapOf(
          entity to "$path/$subEntityName/src/main/java/$packageName/$moduleName/entity",

          controller to "$path/$subMapperName/src/main/java/$packageName/$moduleName/controller",
          mapper to "$path/$subMapperName/src/main/java/$packageName/$moduleName/mapper",
          service to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service",
          serviceImpl to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service/impl",

          xml to "$path/$subMapperName/src/main/resources/mapper"
        )
      )
  }

  generator.strategyConfig {it: StrategyConfig.Builder ->
    it.addExclude("undo_log")
      .addTablePrefix("t_")
      .entityBuilder()
      .enableColumnConstant()
      .enableLombok()
      .enableTableFieldAnnotation()
      .enableChainModel()
      .versionColumnName("version")
      // .addTableFills(
      //   listOf(
      //     Column("creator_name", INSERT),
      //     Column("created_time", INSERT),
      //     Column("updater_name", INSERT_UPDATE),
      //     Column("updated_time", INSERT_UPDATE)
      //   )
      // )
      .idType(ASSIGN_ID)
      // .enableActiveRecord().superClass(Model::class.jvmName)
      .superClass(Entity::class.jvmName)
      .formatFileName("%sEntity")

      .mapperBuilder()
      .superClass(IMapper::class.jvmName)
      .formatMapperFileName("I%sMapper")

      .serviceBuilder()
      .superServiceClass(IService::class.jvmName)
      .formatServiceFileName("I%sService")
      .superServiceImplClass(ServiceImpl::class.jvmName)
      .formatServiceImplFileName("%sServiceImpl")
  }

  generator.templateConfig {it: TemplateConfig.Builder ->
    it.disable(CONTROLLER)
      .entity("/entity.java")
      .entityKt("/entity.kt")
      .mapper("/mapper.java")
      .service("/service.java")
      .serviceImpl("/serviceImpl.java")
  }

  generator.templateEngine(FreemarkerTemplateEngine())
  generator.execute()

  //重新生成枚举
  // del("$path/$subEntityName/src/main/java/$packageName/$moduleName/dict")
  // val ds = SimpleDataSource(url, username, password)
  //
  // val list: MutableList<Item> = use(ds).findAll(create("sys_dict_item"), Item::class.java)
  // val engine: TemplateEngine = TemplateUtil.createEngine()
  // val map: Map<String, List<Item>> = list.groupBy(Item::dictName)
  // map.forEach {(dictName, list) ->
  //   val name = toCamelCase(dictName).replaceFirstChar {it.uppercase()}
  //   val params = mapOf(
  //     "name" to name,
  //     "list" to list,
  //     "pack" to "$packageName/$moduleName/dict".replace('/', '.')
  //   )
  //   val fileName = if (enableKotlin) "$name.kt" else "$name.java"
  //   val template = if (enableKotlin) "enum.kt.ftl" else "enum.java.ftl"
  //   val content: String = engine.getTemplate(readUtf8String(template)).render(params)
  //   writeUtf8String(content, "$path/$subEntityName/src/main/java/$packageName/$moduleName/dict/$fileName")
  // }
}

@Suppress("unused")
class Item {
  lateinit var dictName: String
  lateinit var name: String
  lateinit var label: String
  lateinit var intro: String
  var code: Int = 0
}
