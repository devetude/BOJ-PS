package boj_20040

import java.util.StringTokenizer

private lateinit var parentOf: IntArray

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    parentOf = IntArray(n) { it }
    repeat(m) {
        st = StringTokenizer(readln())
        val x = st.nextToken().toInt()
        val y = st.nextToken().toInt()
        if (isCycleCreatedBy(x, y)) return print(it + 1)
    }

    print(0)
}

private fun isCycleCreatedBy(x: Int, y: Int): Boolean {
    val parentOfX = find(x)
    val parentOfY = find(y)
    if (parentOfX == parentOfY) return true

    if (parentOfX < parentOfY) {
        parentOf[parentOfY] = parentOfX
    } else {
        parentOf[parentOfX] = parentOfY
    }

    return false
}

private fun find(x: Int): Int =
    if (parentOf[x] == x) x else find(parentOf[x]).also { parentOf[x] = it }
