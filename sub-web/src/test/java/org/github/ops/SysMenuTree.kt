package org.github.ops

internal class SysMenuTree(val id: String, val pid: String?, val name: String, var children: List<SysMenuTree> = emptyList())
