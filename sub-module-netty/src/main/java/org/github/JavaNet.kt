package org.github

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.ServerSocket

fun main() {
  val serverSocket = ServerSocket(8000)
  val socket = serverSocket.accept()
  val input = BufferedReader(InputStreamReader(socket.getInputStream()))
  val output = PrintWriter(socket.getOutputStream(), true)
  var req: String? = input.readLine()
  while(req != null) {
    println(req)
    output.println(req)
    req = input.readLine()
  }
}
