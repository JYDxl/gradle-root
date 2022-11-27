package org.github.mbp

import cn.hutool.core.io.FileUtil.*
import cn.hutool.core.util.StrUtil.toCamelCase
import cn.hutool.db.Db.use
import cn.hutool.db.Entity.create
import cn.hutool.db.ds.simple.SimpleDataSource
import cn.hutool.extra.template.TemplateEngine
import cn.hutool.extra.template.TemplateUtil
import com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID
import com.baomidou.mybatisplus.generator.FastAutoGenerator
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.OutputFile.*
import com.baomidou.mybatisplus.generator.config.TemplateType.CONTROLLER
import com.baomidou.mybatisplus.generator.config.TemplateType.XML
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import org.github.base.Entity
import org.github.base.IMapper
import org.github.base.IService
import org.github.base.ServiceImpl
import java.lang.System.getProperty
import kotlin.reflect.jvm.jvmName

fun main() {
  mysqlWeb()
  mysqlSccore()
}

fun mysqlWeb() {
  val url = "jdbc:mysql://frp:3306/web"
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

  val parent = "org.github.mysql.web"
  val moduleName = "base"
  val subName = "sub-mysql-web"
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
      .versionColumnName("revision")
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
      .disable(XML)
      .entity("/entity.java")
      .entityKt("/entity.kt")
      .mapper("/mapper.java")
      .service("/service.java")
      .serviceImpl("/serviceImpl.java")
  }

  generator.templateEngine(FreemarkerTemplateEngine())
  generator.execute()
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
      .versionColumnName("revision")
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
      .disable(XML)
      .entity("/entity.java")
      .entityKt("/entity.kt")
      .mapper("/mapper.java")
      .service("/service.java")
      .serviceImpl("/serviceImpl.java")
  }

  generator.templateEngine(FreemarkerTemplateEngine())
  generator.execute()

  // 重新生成枚举
  del("$path/$subEntityName/src/main/java/$packageName/$moduleName/dict")
  val ds = SimpleDataSource(url, username, password)

  val dictList: MutableList<Dict> = use(ds).findAll(create("t_sys_dict"), Dict::class.java)
  val index = dictList.associateBy {it.dictCode}

  val itemList: MutableList<Item> = use(ds).findAll(create("t_sys_dict_item"), Item::class.java)
  val engine: TemplateEngine = TemplateUtil.createEngine()
  val map: Map<String, List<Item>> = itemList.groupBy(Item::dictCode)
  map.forEach {(dictName, list) ->
    val name = toCamelCase(dictName).replaceFirstChar {it.uppercase()}
    val params = mapOf(
      "name" to name,
      "list" to list,
      "type" to index[dictName],
      "pack" to "$packageName/$moduleName/dict".replace('/', '.')
    )
    val fileName = if (enableKotlin) "$name.kt" else "$name.java"
    val template = if (enableKotlin) "enum.kt.ftl" else "enum.java.ftl"
    val content: String = engine.getTemplate(readUtf8String(template)).render(params)
    writeUtf8String(content, "$path/$subEntityName/src/main/java/$packageName/$moduleName/dict/$fileName")
  }
}

@Suppress("unused")
class Item {
  lateinit var dictCode: String
  lateinit var itemCode: String
  lateinit var itemName: String
  lateinit var itemInfo: String
}

@Suppress("unused")
class Dict {
  lateinit var dictCode: String
  lateinit var dictName: String
  lateinit var dictInfo: String
}
