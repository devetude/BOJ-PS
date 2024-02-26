package boj_12577

import java.util.StringTokenizer

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()

        val root = Node()
        repeat(n) { root.add(readln()) }

        var count = 0
        repeat(m) { count += root.add(readln()) }

        sb.append("Case #").append(it + 1).append(": ").appendLine(count)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

data class Node(val c: Char = ' ') {
    private val children: Array<Node?> = Array(size = 36) { null }
    private var isTerminal: Boolean = false

    fun add(path: String): Int {
        var node = this
        var count = 0
        path.forEach { c ->
            if (c == '/') {
                if (!node.isTerminal && node.c != ' ') ++count
                node.isTerminal = true
                return@forEach
            }

            val i = c.toIndex()
            if (node.children[i] == null) node.children[i] = Node(c)
            node = requireNotNull(node.children[i])
        }
        if (!node.isTerminal && node.c != ' ') ++count
        node.isTerminal = true

        return count
    }

    private fun Char.toIndex(): Int = if (this in 'a'..'z') this - 'a' else this - '0' + 26
}
