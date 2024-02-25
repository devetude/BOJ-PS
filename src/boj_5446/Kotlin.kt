package boj_5446

var count: Int = 0

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val root = Node()
        repeat(readln().toInt()) { root.add(readln()) }
        repeat(readln().toInt()) { root.setUnableToRemove(readln()) }

        count = 0
        countRemovableOf(root)
        sb.appendLine(count)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

fun countRemovableOf(node: Node) {
    if (node.isRemovable) {
        ++count
        return
    } else if (node.isTerminal) {
        ++count
    }

    node.children.values.forEach(::countRemovableOf)
}

data class Node(
    val c: Char = ' ',
    val children: HashMap<Char, Node> = hashMapOf(),
    var isTerminal: Boolean = false,
    var isRemovable: Boolean = true
) {
    fun add(name: String) {
        var node = this
        for (c in name) {
            if (node.children[c] == null) node.children[c] = Node(c)
            node = requireNotNull(node.children[c])
        }
        node.isTerminal = true
    }

    fun setUnableToRemove(name: String) {
        var node = this
        for (c in name) {
            node.isRemovable = false
            if (node.children[c] == null) return
            node = requireNotNull(node.children[c])
        }
        node.isRemovable = false
    }
}
