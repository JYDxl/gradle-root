package org.github.mbp

import com.baomidou.mybatisplus.annotation.FieldFill.INSERT
import com.baomidou.mybatisplus.annotation.FieldFill.INSERT_UPDATE
import com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID
import com.baomidou.mybatisplus.generator.FastAutoGenerator
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.OutputFile.*
import com.baomidou.mybatisplus.generator.config.TemplateType.CONTROLLER
import com.baomidou.mybatisplus.generator.config.TemplateType.XML
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
}

fun mysqlMydb() {
  val url = "jdbc:mysql://jydxl.link:3306/mydb"
  val username = "root"
  val password = "XLrootJYD713"
  val dataSourceBuilder = DataSourceConfig.Builder(url, username, password)

  val generator: FastAutoGenerator = FastAutoGenerator.create(dataSourceBuilder)

  generator.globalConfig {it: GlobalConfig.Builder ->
    it.author("JYD_XL")
      .fileOverride()
      .enableSwagger()
      .enableKotlin()
      .disableOpenDir()
  }

  generator.packageConfig {it: PackageConfig.Builder ->
    val parent = "org.github.mysql.mydb"
    val moduleName = "base"
    val subName = "sub-mysql-mydb"
    val subEntityName = "$subName-entity"
    val subMapperName = "$subName-service"
    val packageName = parent.replace('.', '/')
    val path = "${getProperty("user.dir")}/"

    it.parent(parent)
      .moduleName(moduleName)
      .pathInfo(
        mapOf(
          entity to "$path/$subEntityName/src/main/java/$packageName/$moduleName/entity",

          controller to "$path/$subMapperName/src/main/java/$packageName/$moduleName/controller",
          mapper to "$path/$subMapperName/src/main/java/$packageName/$moduleName/mapper",
          service to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service",
          serviceImpl to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service/impl",

          mapperXml to "$path/$subMapperName/src/main/resources/mapper"
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
