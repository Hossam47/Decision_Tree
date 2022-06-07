package tree

sealed class Tree {
    data class Node(val label: String, val children: Map<String, Tree>?) : Tree()
    data class Leaf(val result: Boolean) : Tree()
}
