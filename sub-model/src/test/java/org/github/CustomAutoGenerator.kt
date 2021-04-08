package org.github

import com.baomidou.mybatisplus.extension.activerecord.Model
import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder
import kotlin.reflect.jvm.jvmName

class CustomAutoGenerator: AutoGenerator() {
  override fun pretreatmentConfigBuilder(config: ConfigBuilder) = requireNotNull(super.pretreatmentConfigBuilder(config)).apply {
    tableInfoList.forEach {it.importPackages.remove(Model::class.jvmName)}
  }
}
