package org.github

import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy.*
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import java.lang.System.*

fun main() {
  val generator = AutoGenerator().apply { templateEngine = FreemarkerTemplateEngine() }

  GlobalConfig().apply {
    val path = getProperty("user.dir")!!
    outputDir = "$path/sub-model/src/main/java"
    serviceImplName = "%sServiceImpl"
    serviceName = "I%sService"
    mapperName = "I%sMapper"
    entityName = "%sEntity"
    isFileOverride = true
    isOpen = false
    author = "JYD_XL"
    // idType = UUID
    generator.globalConfig = this
  }

  DataSourceConfig().apply {
    url = "jdbc:mysql://localhost:3380/sample?useSSL=false"
    driverName = "com.mysql.cj.jdbc.Driver"
    username = "root"
    password = "l"
    generator.dataSource = this
  }

  PackageConfig().apply {
    parent = "org.github"
    moduleName = "base"
    generator.packageInfo = this
  }

  StrategyConfig().apply {
    naming = underline_to_camel
    isEntityLombokModel = true
    isEntityTableFieldAnnotationEnable = true
    logicDeleteFieldName = "deleted"
    superEntityClass = "org.github.base.AbstractEntity"
    superMapperClass = "org.github.base.IMapper"
    superServiceClass = "org.github.base.IService"
    superServiceImplClass = "org.github.base.ServiceImpl"
    setInclude(".+")
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
