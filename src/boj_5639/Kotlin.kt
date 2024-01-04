package boj_5639

val sb = StringBuilder()

fun main() {
    val root = Node(readln().toInt())
    while (true) readlnOrNull()?.toInt()?.let(root::add) ?: break
    postorder(root)

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

fun postorder(node: Node) {
    node.left?.let(::postorder)
    node.right?.let(::postorder)
    sb.appendLine(node.value)
}

data class Node(
    val value: Int,
    var left: Node? = null,
    var right: Node? = null
) {
    fun add(value: Int) {
        if (value < this.value) {
            left?.add(value) ?: run { left = Node(value) }
        } else {
            right?.add(value) ?: run { right = Node(value) }
        }
    }
}
