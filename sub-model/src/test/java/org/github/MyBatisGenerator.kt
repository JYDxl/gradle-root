package org.github

import com.baomidou.mybatisplus.annotation.IdType.*
import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.config.DataSourceConfig
import com.baomidou.mybatisplus.generator.config.GlobalConfig
import com.baomidou.mybatisplus.generator.config.PackageConfig
import com.baomidou.mybatisplus.generator.config.StrategyConfig
import com.baomidou.mybatisplus.generator.config.TemplateConfig
import com.baomidou.mybatisplus.generator.config.po.LikeTable
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy.*
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import org.github.base.AbstractEntity
import java.lang.System.*

fun main() {
  val generator = AutoGenerator().apply { templateEngine = FreemarkerTemplateEngine() }

  GlobalConfig().apply {
    val path = checkNotNull(getProperty("user.dir"))
    outputDir = "$path/sub-model/src/main/java"
    serviceImplName = "%sServiceImpl"
    serviceName = "I%sService"
    mapperName = "I%sMapper"
    entityName = "%sEntity"
    isFileOverride = true
    isOpen = false
    author = "JYD_XL"
    idType = ASSIGN_ID
    generator.globalConfig = this
  }

  DataSourceConfig().apply {
    url = "jdbc:mysql://ubuntu:3380/shop"
    driverName = "com.mysql.cj.jdbc.Driver"
    username = "root"
    password = "root"
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
    setSuperEntityClass(AbstractEntity::class.java)
    superMapperClass = "org.github.base.IMapper"
    superServiceClass = "org.github.base.IService"
    superServiceImplClass = "org.github.base.ServiceImpl"
    likeTable = LikeTable("_")
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
