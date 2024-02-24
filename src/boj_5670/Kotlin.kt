package boj_5670

fun main() {
    val sb = StringBuilder()
    while (true) {
        val n = readlnOrNull()?.toInt() ?: break
        val words = Array(n) { readln() }

        val root = Node()
        words.forEach { word ->
            var node = root
            word.forEach { c ->
                if (node.children[c] == null) node.children[c] = Node(c)
                node = requireNotNull(node.children[c])
            }
            node.isTerminal = true
        }

        var totalPressCount = 0
        words.forEach { word ->
            var node = requireNotNull(root.children[word[0]])
            var pressCount = 1
            for (i in 1 until word.length) {
                if (1 < node.children.size) ++pressCount
                else if (node.children.size == 1 && node.isTerminal) ++pressCount

                node = requireNotNull(node.children[word[i]])
            }
            totalPressCount += pressCount
        }

        val average = String.format("%.2f", totalPressCount.toDouble() / n)
        sb.appendLine(average)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

data class Node(
    val c: Char = ' ',
    val children: HashMap<Char, Node> = hashMapOf(),
    var isTerminal: Boolean = false
)
