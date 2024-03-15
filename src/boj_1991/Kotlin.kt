package boj_1991

import java.util.StringTokenizer

private val tree: HashMap<String, Pair<String, String>> = HashMap()
private val resultBuilder: StringBuilder = StringBuilder()

fun main() {
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val parent = st.nextToken().toString()
        val left = st.nextToken().toString()
        val right = st.nextToken().toString()
        tree[parent] = left to right
    }

    preorder()
    resultBuilder.appendLine()
    inorder()
    resultBuilder.appendLine()
    postorder()

    System.out.bufferedWriter().use {
        it.write(resultBuilder.toString())
        it.flush()
    }
}

private fun preorder(u: String = "A") {
    val (left, right) = requireNotNull(tree[u])
    resultBuilder.append(u)
    left.takeIf { it != "." }?.let(::preorder)
    right.takeIf { it != "." }?.let(::preorder)
}

private fun inorder(u: String = "A") {
    val (left, right) = requireNotNull(tree[u])
    left.takeIf { it != "." }?.let(::inorder)
    resultBuilder.append(u)
    right.takeIf { it != "." }?.let(::inorder)
}

private fun postorder(u: String = "A") {
    val (left, right) = requireNotNull(tree[u])
    left.takeIf { it != "." }?.let(::postorder)
    right.takeIf { it != "." }?.let(::postorder)
    resultBuilder.append(u)
}
