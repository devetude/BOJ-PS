package boj_2250

import java.util.LinkedList
import java.util.StringTokenizer

var col: Int = 1
lateinit var colsOf: Array<LinkedList<Int>>
lateinit var tree: Array<Pair<Int, Int>>

fun main() {
    val n = readln().toInt()

    tree = Array(size = n + 1) { -1 to -1 }
    val isRoot = BooleanArray(size = n + 1) { true }.apply { this[0] = false }
    repeat(n) {
        val st = StringTokenizer(readln())
        val value = st.nextToken().toInt()
        val left = st.nextToken().toInt()
        val right = st.nextToken().toInt()

        tree[value] = left to right
        if (left != -1) isRoot[left] = false
        if (right != -1) isRoot[right] = false
    }

    colsOf = Array(size = n + 1) { LinkedList() }
    val root = isRoot.indexOfFirst { it }
    inorder(root)

    var maxWidthLevel = 1
    var maxWidth = 1
    for (level in 1..n) {
        val cols = colsOf[level]
        if (cols.isEmpty()) break

        val width = cols.last - cols.first + 1
        if (maxWidth < width) {
            maxWidthLevel = level
            maxWidth = width
        }
    }

    print("$maxWidthLevel $maxWidth")
}

fun inorder(value: Int, level: Int = 1) {
    if (value == -1) return

    val (left, right) = tree[value]
    inorder(left, level = level + 1)
    colsOf[level].add(col++)
    inorder(right, level = level + 1)
}
