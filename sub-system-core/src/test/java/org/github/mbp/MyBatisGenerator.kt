package org.github.mbp

import com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID
import com.baomidou.mybatisplus.extension.service.IService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import com.baomidou.mybatisplus.generator.SimpleAutoGenerator
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.ConstVal.*
import com.baomidou.mybatisplus.generator.config.TemplateType.CONTROLLER
import com.baomidou.mybatisplus.generator.config.TemplateType.XML
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy.underline_to_camel
import com.baomidou.mybatisplus.generator.engine.AbstractTemplateEngine
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import org.github.base.*
import java.lang.System.getProperty
import kotlin.reflect.jvm.jvmName

fun main() {
  mydb()
  seataAccount()
  seataOrder()
  seataStorage()
}

fun mydb() {
  object: SimpleAutoGenerator() {
    override fun globalConfigBuilder(): IConfigBuilder<GlobalConfig> {
      return GlobalConfig.Builder()
        .author("JYD_XL")
        .fileOverride()
        .enableSwagger()
        .enableKotlin()
        .openDir(false)
    }

    override fun dataSourceConfigBuilder(): IConfigBuilder<DataSourceConfig> {
      val url = "jdbc:mysql://jydxl.link:3306/mydb"
      val username = "root"
      val password = "XLrootJYD713"

      return DataSourceConfig.Builder(url, username, password)
    }

    override fun packageConfigBuilder(): IConfigBuilder<PackageConfig> {
      val parent = "org.github.mysql.mydb"
      val moduleName = "base"
      val subName = "sub-mysql-mydb"
      val subEntityName = "$subName-entity"
      val subMapperName = "$subName-service"
      val packageName = parent.replace('.', '/')
      val path = "${getProperty("user.dir")}/"

      return PackageConfig.Builder()
        .parent(parent)
        .moduleName(moduleName)
        .pathInfo(
          mapOf(
            ENTITY_PATH to "$path/$subEntityName/src/main/java/$packageName/$moduleName/entity",

            CONTROLLER_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/controller",
            MAPPER_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/mapper",
            SERVICE_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service",
            SERVICE_IMPL_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service/impl",

            XML_PATH to "$path/$subMapperName/src/main/resources/mapper"
          )
        )
    }

    override fun strategyConfigBuilder(): IConfigBuilder<StrategyConfig> {
      return StrategyConfig.Builder()
        .addExclude("undo_log")
        .entityBuilder()
        .enableLombok()
        .enableTableFieldAnnotation()
        .enableSerialVersionUID()
        .idType(ASSIGN_ID)
        .naming(underline_to_camel)
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

    override fun templateConfigBuilder(): IConfigBuilder<TemplateConfig> {
      return TemplateConfig.Builder()
        .disable(CONTROLLER)
        .disable(XML)
        .entity("/entity.java")
        .entityKt("/entity.kt")
        .mapper("/mapper.java")
        .service("/service.java", "/serviceImpl.java")
    }

    override fun templateEngine(): AbstractTemplateEngine {
      return FreemarkerTemplateEngine()
    }
  }.execute()
}

fun seataAccount() {
  object: SimpleAutoGenerator() {
    override fun globalConfigBuilder(): IConfigBuilder<GlobalConfig> {
      return GlobalConfig.Builder()
        .author("JYD_XL")
        .fileOverride()
        .enableSwagger()
        .enableKotlin()
        .openDir(false)
    }

    override fun dataSourceConfigBuilder(): IConfigBuilder<DataSourceConfig> {
      val url = "jdbc:mysql://jydxl.link:3306/seata_account"
      val username = "root"
      val password = "XLrootJYD713"

      return DataSourceConfig.Builder(url, username, password)
    }

    override fun packageConfigBuilder(): IConfigBuilder<PackageConfig> {
      val parent = "org.github.mysql.seata.account"
      val moduleName = "base"
      val subName = "sub-mysql-seata-account"
      val subEntityName = "$subName-entity"
      val subMapperName = "$subName-service"
      val packageName = parent.replace('.', '/')
      val path = "${getProperty("user.dir")}/"

      return PackageConfig.Builder()
        .parent(parent)
        .moduleName(moduleName)
        .pathInfo(
          mapOf(
            ENTITY_PATH to "$path/$subEntityName/src/main/java/$packageName/$moduleName/entity",

            CONTROLLER_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/controller",
            MAPPER_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/mapper",
            SERVICE_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service",
            SERVICE_IMPL_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service/impl",

            XML_PATH to "$path/$subMapperName/src/main/resources/mapper"
          )
        )
    }

    override fun strategyConfigBuilder(): IConfigBuilder<StrategyConfig> {
      return StrategyConfig.Builder()
        .addExclude("undo_log")
        .entityBuilder()
        .enableLombok()
        .enableTableFieldAnnotation()
        .enableSerialVersionUID()
        .idType(ASSIGN_ID)
        .naming(underline_to_camel)
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

    override fun templateConfigBuilder(): IConfigBuilder<TemplateConfig> {
      return TemplateConfig.Builder()
        .disable(CONTROLLER)
        .disable(XML)
        .entity("/entity.java")
        .entityKt("/entity.kt")
        .mapper("/mapper.java")
        .service("/service.java", "/serviceImpl.java")
    }

    override fun templateEngine(): AbstractTemplateEngine {
      return FreemarkerTemplateEngine()
    }
  }.execute()
}

fun seataOrder() {
  object: SimpleAutoGenerator() {
    override fun globalConfigBuilder(): IConfigBuilder<GlobalConfig> {
      return GlobalConfig.Builder()
        .author("JYD_XL")
        .fileOverride()
        .enableSwagger()
        .enableKotlin()
        .openDir(false)
    }

    override fun dataSourceConfigBuilder(): IConfigBuilder<DataSourceConfig> {
      val url = "jdbc:mysql://jydxl.link:3306/seata_order"
      val username = "root"
      val password = "XLrootJYD713"

      return DataSourceConfig.Builder(url, username, password)
    }

    override fun packageConfigBuilder(): IConfigBuilder<PackageConfig> {
      val parent = "org.github.mysql.seata.order"
      val moduleName = "base"
      val subName = "sub-mysql-seata-order"
      val subEntityName = "$subName-entity"
      val subMapperName = "$subName-service"
      val packageName = parent.replace('.', '/')
      val path = "${getProperty("user.dir")}/"

      return PackageConfig.Builder()
        .parent(parent)
        .moduleName(moduleName)
        .pathInfo(
          mapOf(
            ENTITY_PATH to "$path/$subEntityName/src/main/java/$packageName/$moduleName/entity",

            CONTROLLER_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/controller",
            MAPPER_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/mapper",
            SERVICE_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service",
            SERVICE_IMPL_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service/impl",

            XML_PATH to "$path/$subMapperName/src/main/resources/mapper"
          )
        )
    }

    override fun strategyConfigBuilder(): IConfigBuilder<StrategyConfig> {
      return StrategyConfig.Builder()
        .addExclude("undo_log")
        .entityBuilder()
        .enableLombok()
        .enableTableFieldAnnotation()
        .enableSerialVersionUID()
        .idType(ASSIGN_ID)
        .naming(underline_to_camel)
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

    override fun templateConfigBuilder(): IConfigBuilder<TemplateConfig> {
      return TemplateConfig.Builder()
        .disable(CONTROLLER)
        .disable(XML)
        .entity("/entity.java")
        .entityKt("/entity.kt")
        .mapper("/mapper.java")
        .service("/service.java", "/serviceImpl.java")
    }

    override fun templateEngine(): AbstractTemplateEngine {
      return FreemarkerTemplateEngine()
    }
  }.execute()
}

fun seataStorage() {
  object: SimpleAutoGenerator() {
    override fun globalConfigBuilder(): IConfigBuilder<GlobalConfig> {
      return GlobalConfig.Builder()
        .author("JYD_XL")
        .fileOverride()
        .enableSwagger()
        .enableKotlin()
        .openDir(false)
    }

    override fun dataSourceConfigBuilder(): IConfigBuilder<DataSourceConfig> {
      val url = "jdbc:mysql://jydxl.link:3306/seata_storage"
      val username = "root"
      val password = "XLrootJYD713"

      return DataSourceConfig.Builder(url, username, password)
    }

    override fun packageConfigBuilder(): IConfigBuilder<PackageConfig> {
      val parent = "org.github.mysql.seata.storage"
      val moduleName = "base"
      val subName = "sub-mysql-seata-storage"
      val subEntityName = "$subName-entity"
      val subMapperName = "$subName-service"
      val packageName = parent.replace('.', '/')
      val path = "${getProperty("user.dir")}/"

      return PackageConfig.Builder()
        .parent(parent)
        .moduleName(moduleName)
        .pathInfo(
          mapOf(
            ENTITY_PATH to "$path/$subEntityName/src/main/java/$packageName/$moduleName/entity",

            CONTROLLER_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/controller",
            MAPPER_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/mapper",
            SERVICE_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service",
            SERVICE_IMPL_PATH to "$path/$subMapperName/src/main/java/$packageName/$moduleName/service/impl",

            XML_PATH to "$path/$subMapperName/src/main/resources/mapper"
          )
        )
    }

    override fun strategyConfigBuilder(): IConfigBuilder<StrategyConfig> {
      return StrategyConfig.Builder()
        .addExclude("undo_log")
        .entityBuilder()
        .enableLombok()
        .enableTableFieldAnnotation()
        .enableSerialVersionUID()
        .idType(ASSIGN_ID)
        .naming(underline_to_camel)
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

    override fun templateConfigBuilder(): IConfigBuilder<TemplateConfig> {
      return TemplateConfig.Builder()
        .disable(CONTROLLER)
        .disable(XML)
        .entity("/entity.java")
        .entityKt("/entity.kt")
        .mapper("/mapper.java")
        .service("/service.java", "/serviceImpl.java")
    }

    override fun templateEngine(): AbstractTemplateEngine {
      return FreemarkerTemplateEngine()
    }
  }.execute()
}
