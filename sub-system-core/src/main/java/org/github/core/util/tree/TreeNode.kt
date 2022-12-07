package org.github.core.util.tree

import org.github.core.base.IJson

interface TreeNode<I, E>: IJson {
  val id: I

  val pid: I?

  val name: String

  var extra: E?

  var child: MutableCollection<out TreeNode<I, E>>?
}
