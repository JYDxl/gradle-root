package org.github.mbp

import com.baomidou.mybatisplus.annotation.IdType.ASSIGN_ID
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.po.LikeTable
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy.underline_to_camel
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine
import org.github.base.IMapper
import org.github.base.IService
import org.github.base.Model
import org.github.base.ServiceImpl
import java.lang.System.getProperty
import kotlin.reflect.jvm.jvmName

fun main() {
  val generator = CustomAutoGenerator().apply {templateEngine = FreemarkerTemplateEngine()}

  GlobalConfig().apply {
    val path = requireNotNull(getProperty("user.dir"))
    outputDir = "$path/sub-web-model/src/main/java"
    serviceImplName = "%sServiceImpl"
    serviceName = "I%sService"
    mapperName = "I%sMapper"
    entityName = "%sEntity"
    author = "JYD_XL"
    idType = ASSIGN_ID
    isFileOverride = true
    isActiveRecord = true
    isSwagger2 = true
    isOpen = false
    generator.globalConfig = this
  }

  DataSourceConfig().apply {
    url = "jdbc:mysql://ubuntu:3380/web"
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
    isEntityTableFieldAnnotationEnable = true
    isEntityLombokModel = true
    superEntityClass = Model::class.jvmName
    superMapperClass = IMapper::class.jvmName
    superServiceClass = IService::class.jvmName
    superServiceImplClass = ServiceImpl::class.jvmName
    logicDeleteFieldName = "deleted"
    versionFieldName = "version"
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
