package org.github.util.tree

import org.github.base.IJson
import java.util.*

interface TreeNode<I, E>: IJson {
  val id: I

  val pid: Optional<I>

  val name: String

  var extra: E?

  var child: MutableCollection<out TreeNode<I, E>>?
}
