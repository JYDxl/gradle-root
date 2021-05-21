package org.github.mbp

import com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.ConstVal.*
import com.baomidou.mybatisplus.generator.config.po.LikeTable
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy.underline_to_camel
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import org.github.base.*
import java.lang.System.getProperty
import kotlin.reflect.jvm.jvmName

fun main() {
  val generator = CustomAutoGenerator().apply {templateEngine = FreemarkerTemplateEngine()}

  GlobalConfig().apply {
    val path: String = getProperty("user.dir")
    outputDir = "$path/src/main/java"
    outputDir = null
    serviceImplName = "%sServiceImpl"
    serviceName = "I%sService"
    mapperName = "I%sMapper"
    entityName = "%sEntity"
    author = "JYD_XL"
    idType = ASSIGN_ID
    isFileOverride = true
    isSwagger2 = true
    isOpen = false

    generator.globalConfig = this
  }

  DataSourceConfig().apply {
    url = "jdbc:mysql://www.jydxl.link:3306/web"
    driverName = "com.mysql.cj.jdbc.Driver"
    username = "root"
    password = "XLrootJYD713"

    generator.dataSource = this
  }

  PackageConfig().apply {
    parent = "org.github.mysql.web"
    moduleName = "base"

    val subName = "sub-mysql-web"
    val subEntityName = "$subName-entity"
    val subMapperName = "$subName-service"
    val packageName = parent.replace('.', '/')
    val path = "${getProperty("user.dir")}/"

    pathInfo = mapOf(
      ENTITY_PATH to "$path/$subEntityName/src/main/java/$packageName/entity",
      MAPPER_PATH to "$path/$subMapperName/src/main/java/$packageName/mapper",
      SERVICE_PATH to "$path/$subMapperName/src/main/java/$packageName/service",
      SERVICE_IMPL_PATH to "$path/$subMapperName/src/main/java/$packageName/service/impl"
    )

    generator.packageInfo = this
  }

  StrategyConfig().apply {
    naming = underline_to_camel
    isEntityTableFieldAnnotationEnable = true
    isEntityLombokModel = true
    superEntityClass = IEntity::class.jvmName
    superMapperClass = IMapper::class.jvmName
    superServiceClass = IService::class.jvmName
    superServiceImplClass = ServiceImpl::class.jvmName
    // logicDeleteFieldName = "deleted"
    // versionFieldName = "version"
    likeTable = LikeTable("")

    generator.strategy = this
  }

  TemplateConfig().apply {
    controller = null
    xml = null
    service = "service.java"
    serviceImpl = "serviceImpl.java"
    mapper = "mapper.java"
    setEntity("entity.java")

    generator.template = this
  }

  generator.execute()
}
