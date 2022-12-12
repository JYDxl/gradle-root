val commonsPool2: String by System.getProperties()
val mybatisPlus: String by System.getProperties()
val retrofit: String by System.getProperties()
val jetcache: String by System.getProperties()
val dynamic: String by System.getProperties()
val saToken: String by System.getProperties()
val forest: String by System.getProperties()
val xxljob: String by System.getProperties()
val minio: String by System.getProperties()
val p6spy: String by System.getProperties()

dependencies {
  api(project(":sub-system-core"))
  api(project(":sub-module-center-api"))

  api("org.springframework.cloud:spring-cloud-starter-bootstrap")
  api("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-discovery")
  api("com.alibaba.cloud:spring-cloud-starter-alibaba-nacos-config")
  api("org.springframework.cloud:spring-cloud-starter-openfeign")
  api("org.springframework.cloud:spring-cloud-starter-loadbalancer")

  api("org.springframework.boot:spring-boot-starter-validation")
  api("org.springframework.boot:spring-boot-starter-actuator")
  api("org.springframework.boot:spring-boot-starter-web")
  api("org.springframework.boot:spring-boot-starter-aop")

  api("com.baomidou:dynamic-datasource-spring-boot-starter:$dynamic")
  api("com.baomidou:mybatis-plus-boot-starter:$mybatisPlus")
  api("p6spy:p6spy:$p6spy")

  api("cn.dev33:sa-token-spring-boot-starter:$saToken")
  api("cn.dev33:sa-token-dao-redis-jackson:$saToken")
  api("cn.dev33:sa-token-alone-redis:$saToken")
  api("cn.dev33:sa-token-sso:$saToken")
  api("cn.dev33:sa-token-jwt:$saToken") {exclude(group = "cn.hutool")}

  api("com.alicp.jetcache:jetcache-starter-redis-lettuce:$jetcache")
  api("com.dtflys.forest:forest-spring-boot-starter:$forest")
  api("org.apache.commons:commons-pool2:$commonsPool2")
  api("com.squareup.retrofit2:retrofit:$retrofit")
  api("com.xuxueli:xxl-job-core:$xxljob")
  api("io.minio:minio:$minio")

  annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
}
