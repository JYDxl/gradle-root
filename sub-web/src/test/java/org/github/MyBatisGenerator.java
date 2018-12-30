package org.github;

import lombok.val;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import static com.baomidou.mybatisplus.annotation.IdType.ID_WORKER_STR;
import static com.baomidou.mybatisplus.generator.config.rules.NamingStrategy.underline_to_camel;
import static java.lang.System.getProperty;

public class MyBatisGenerator {
  public static void main(String[] args) {
    val path         = getProperty("user.dir");
    val globalConfig = new GlobalConfig();
    globalConfig
      .setOutputDir(path + "/sub-web/src/main/java")
      .setFileOverride(true)
      .setOpen(false)
      .setAuthor("JYD_XL")
      .setBaseResultMap(true)
      .setIdType(ID_WORKER_STR)
      .setEntityName("%sEntity")
      .setMapperName("%sMapper")
      .setXmlName("%sMapper")
      .setServiceName("I%sService")
      .setServiceImplName("%sServiceImpl")
      .setControllerName("%sController");

    val dataSourceConfig = new DataSourceConfig();
    dataSourceConfig
      .setUrl("jdbc:mysql://localhost:3357/shiro?useSSL=false")
      .setDriverName("com.mysql.jdbc.Driver")
      .setUsername("root")
      .setPassword("l");

    val packageConfig = new PackageConfig();
    packageConfig
      .setParent("org.github")
      .setXml("mapper.base")
      .setModuleName("base");

    val strategyConfig = new StrategyConfig();
    strategyConfig
      .setSkipView(true)
      .setNaming(underline_to_camel)
      .setEntityLombokModel(true)
      .setRestControllerStyle(true)
      .setControllerMappingHyphenStyle(true)
      .setInclude(".+");

    val autoGenerator = new AutoGenerator();
    autoGenerator
      .setGlobalConfig(globalConfig)
      .setDataSource(dataSourceConfig)
      .setPackageInfo(packageConfig)
      .setStrategy(strategyConfig)
      .setTemplateEngine(new FreemarkerTemplateEngine())
      .execute();
  }
}
