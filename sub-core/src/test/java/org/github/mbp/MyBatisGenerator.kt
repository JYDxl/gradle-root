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
import org.github.base.Entity
import org.github.base.IMapper
import java.lang.System.getProperty
import kotlin.reflect.jvm.jvmName

fun main() {
    object : SimpleAutoGenerator() {
        override fun globalConfigBuilder(): IConfigBuilder<GlobalConfig> {
            return GlobalConfig.Builder()
                .author("JYD_XL")
                .fileOverride()
                .enableSwagger()
                .enableKotlin()
                .openDir(false)
        }

        override fun dataSourceConfigBuilder(): IConfigBuilder<DataSourceConfig> {
            val url = "jdbc:mysql://www.jydxl.link:3306/web"
            val username = "root"
            val password = "XLrootJYD713"

            return DataSourceConfig.Builder(url, username, password)
        }

        override fun packageConfigBuilder(): IConfigBuilder<PackageConfig> {
            val parent = "org.github.mysql.web"
            val moduleName = "base"
            val subName = "sub-mysql-web"
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
                .entityBuilder()
                .enableLombok()
                .enableTableFieldAnnotation()
                .enableSerialVersionUID()
                .idType(ASSIGN_ID)
                .naming(underline_to_camel)
//                .enableActiveRecord().superClass(Model::class.jvmName)
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
