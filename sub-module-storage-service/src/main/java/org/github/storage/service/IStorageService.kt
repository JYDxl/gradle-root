package org.github.storage.service

import org.github.spring.restful.json.JSONDataReturn
import org.github.storage.dto.DecreaseProductBO

interface IStorageService {
  fun decreaseProduct(bo: DecreaseProductBO): JSONDataReturn<Boolean>
}
