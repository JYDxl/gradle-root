package org.github.core.exception

import org.github.core.spring.restful.json.JSONReturn

class RemoteException(val data: JSONReturn) : RuntimeException()
