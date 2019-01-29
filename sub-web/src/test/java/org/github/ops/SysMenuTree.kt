package org.github.ops

internal class SysMenuTree(val id: String, val pid: String?, val name: String) {
  /** child node. */
  var children: List<SysMenuTree>? = null
}
