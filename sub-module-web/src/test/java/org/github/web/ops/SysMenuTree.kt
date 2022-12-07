package org.github.web.ops

internal data class SysMenuTree(val id: String, val pid: String?, val name: String, var children: List<SysMenuTree> = emptyList())
