package org.github

import com.baomidou.mybatisplus.annotation.IdType.ID_WORKER_STR
import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.config.DataSourceConfig
import com.baomidou.mybatisplus.generator.config.GlobalConfig
import com.baomidou.mybatisplus.generator.config.PackageConfig
import com.baomidou.mybatisplus.generator.config.StrategyConfig
import com.baomidou.mybatisplus.generator.config.TemplateConfig
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy.underline_to_camel
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import java.lang.System.getProperty

fun main(args: Array<String>) {
  val generator = AutoGenerator().apply { templateEngine = FreemarkerTemplateEngine() }

  GlobalConfig().apply {
    outputDir = "${getProperty("user.dir")}/sub-model/src/main/java"
    isFileOverride = true
    isOpen = false
    author = "JYD_XL"
    idType = ID_WORKER_STR
    entityName = "%sEntity"
    serviceImplName = "%sService"
    generator.globalConfig = this
  }

  DataSourceConfig().apply {
    url = "jdbc:mysql://localhost:3357/shiro?useSSL=false"
    driverName = "com.mysql.jdbc.Driver"
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
    setInclude(".+")
    generator.strategy = this
  }

  TemplateConfig().apply {
    service = "service.java"
    serviceImpl = "serviceImpl.java"
    mapper = "mapper.java"
    controller = null
    xml = null
    setEntity("entity.java")
    generator.template = this
  }

  generator.execute()
}
