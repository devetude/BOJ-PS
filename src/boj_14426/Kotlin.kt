package boj_14426

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val trie = Trie()
    repeat(n) { trie.insert(readln()) }

    var count = 0
    repeat(m) { if (trie.startsWith(readln())) ++count }

    print(count)
}

class Trie {
    private val root: Node = Node()

    fun insert(word: String) {
        var current = root
        word.forEach { c ->
            val child = current.children[c] ?: Node().also { current.children[c] = it }
            current = child
        }
    }

    fun startsWith(prefix: String): Boolean {
        var current = root
        prefix.forEach { c -> current = current.children[c] ?: return false }
        return true
    }
}

data class Node(val children: HashMap<Char, Node> = HashMap())
