package org.github.web.service

import org.github.base.entity.UserEntity
import org.github.base.model.dto.UserInfoDTO
import org.github.ops.info
import org.github.ops.log
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
internal class CustomUserServiceTest {
  private val log = CustomUserServiceTest::class.log

  @Autowired
  private lateinit var customUserService: ICustomUserService

  @Test
  fun queryPermissions() {
    val permissions: Set<String> = customUserService.queryPermissions(3)
    log.info {permissions}
  }

  @Test
  fun queryRoles() {
    val roles: Set<String> = customUserService.queryRoles(3)
    log.info {roles}
  }

  @Test
  fun queryUser() {
    val user: UserEntity? = customUserService.queryUser("jack")
    log.info {user}
  }

  @Test
  fun queryUserInfo() {
    val userInfoList: List<UserInfoDTO> = customUserService.queryUserInfo("jack")
    log.info {userInfoList}
  }
}
