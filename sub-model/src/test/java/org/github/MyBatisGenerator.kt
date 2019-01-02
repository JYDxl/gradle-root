package org.github

import com.baomidou.mybatisplus.annotation.IdType.ID_WORKER_STR
import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.config.DataSourceConfig
import com.baomidou.mybatisplus.generator.config.GlobalConfig
import com.baomidou.mybatisplus.generator.config.PackageConfig
import com.baomidou.mybatisplus.generator.config.StrategyConfig
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy.underline_to_camel
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import java.lang.System.getProperty

fun main(args: Array<String>) {
  val autoGenerator = AutoGenerator().apply { templateEngine = FreemarkerTemplateEngine() }

  GlobalConfig().apply {
    val path = getProperty("user.dir")!!
    outputDir = "$path/sub-model/src/main/java"
    isFileOverride = true
    isOpen = false
    author = "JYD_XL"
    isBaseResultMap = true
    idType = ID_WORKER_STR
    entityName = "%sEntity"
    mapperName = "%sMapper"
    xmlName = "%sMapper"
    serviceName = "I%sService"
    serviceImplName = "%sServiceImpl"
    controllerName = "%sController"
    autoGenerator.globalConfig = this
  }

  DataSourceConfig().apply {
    url = "jdbc:mysql://localhost:3357/shiro?useSSL=false"
    driverName = "com.mysql.jdbc.Driver"
    username = "root"
    password = "l"
    autoGenerator.dataSource = this
  }

  PackageConfig().apply {
    parent = "org.github"
    xml = "mapper.base"
    moduleName = "base"
    autoGenerator.packageInfo = this
  }

  StrategyConfig().apply {
    isSkipView = false
    naming = underline_to_camel
    isEntityLombokModel = true
    isEntityBuilderModel = false
    isRestControllerStyle = true
    isControllerMappingHyphenStyle = true
    setInclude(".+")
    autoGenerator.strategy = this
  }

  autoGenerator.execute()
}
