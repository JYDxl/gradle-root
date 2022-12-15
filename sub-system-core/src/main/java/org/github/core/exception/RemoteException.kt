package org.github.core.exception

import org.github.core.spring.restful.json.JSONBase

class RemoteException(val data: JSONBase): RuntimeException()
