package org.github.account.service

import org.github.account.dto.DecreaseAccountBO
import org.github.spring.restful.json.JSONDataReturn

interface IAccountService {
  fun decreaseMoney(bo: DecreaseAccountBO): JSONDataReturn<Boolean>
}
