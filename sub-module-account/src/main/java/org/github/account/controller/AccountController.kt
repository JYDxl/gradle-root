package org.github.account.controller

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.github.account.dto.DecreaseAccountBO
import org.github.account.service.IAccountService
import org.github.ops.trimStrFields
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Api(tags = ["账户管理"])
@RequestMapping("/account/")
@RestController
class AccountController {
  @Autowired
  private lateinit var accountService: IAccountService

  @ApiOperation("减金额")
  @PostMapping("decreaseMoney")
  fun decreaseMoney(@RequestBody @Valid bo: DecreaseAccountBO) = accountService.decreaseMoney(bo.trimStrFields())
}
