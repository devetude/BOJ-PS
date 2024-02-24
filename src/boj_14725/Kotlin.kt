package boj_14725

import java.util.StringTokenizer
import java.util.TreeMap

val resultBuilder: StringBuilder = StringBuilder()

fun main() {
    val n = readln().toInt()

    val root = Node()
    repeat(n) {
        val st = StringTokenizer(readln())
        val k = st.nextToken().toInt()
        var node = root
        repeat(k) {
            val name = st.nextToken()
            if (node.children[name] == null) {
                node.children[name] = Node(name).apply { isTerminal = true }
            }
            node = requireNotNull(node.children[name])
        }
    }

    root.children.values.forEach(::dfs)

    System.out.bufferedWriter().use {
        it.write(resultBuilder.toString())
        it.flush()
    }
}

fun dfs(node: Node, depth: Int = 0) {
    repeat(depth) { resultBuilder.append("--") }
    resultBuilder.appendLine(node.name)
    node.children.values.forEach { dfs(it, if (it.isTerminal) depth + 1 else depth) }
}

data class Node(
    val name: String = "",
    val children: TreeMap<String, Node> = TreeMap(),
    var isTerminal: Boolean = false
)
