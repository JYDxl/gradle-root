package org.github.netty.module.oio

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {
  val serverSocket = ServerSocket(10000)
  val socket = serverSocket.accept()
  val input = BufferedReader(InputStreamReader(socket.getInputStream()))
  val output = PrintWriter(socket.getOutputStream(), true)
  var req = input.readLine()
  var res: String
  while(req != null) {
    if("Done" == req) break
    res = process(req)
    output.println(res)
    req = input.readLine()
  }
}

fun process(req: String): String {
  return req.uppercase()
}
