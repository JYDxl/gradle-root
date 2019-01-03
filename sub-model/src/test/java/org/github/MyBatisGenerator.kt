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
  val generator = AutoGenerator().apply { templateEngine = FreemarkerTemplateEngine() }

  GlobalConfig().apply {
    val path = getProperty("user.dir")!!
    outputDir = "$path/sub-model/src/main/java"
    isFileOverride = true
    isOpen = false
    author = "JYD_XL"
    isBaseResultMap = true
    idType = ID_WORKER_STR
    entityName = "%sEntity"
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
    xml = "mapper.base"
    moduleName = "base"
    generator.packageInfo = this
  }

  StrategyConfig().apply {
    naming = underline_to_camel
    isEntityLombokModel = true
    isRestControllerStyle = true
    isControllerMappingHyphenStyle = true
    setInclude(".+")
    generator.strategy = this
  }

  generator.execute()
}
