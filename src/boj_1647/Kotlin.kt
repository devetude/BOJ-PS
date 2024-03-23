package boj_1647

import java.util.StringTokenizer

private lateinit var parentOf: IntArray

fun main() {
    var st = StringTokenizer(readln())
    var n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val edges = mutableListOf<Triple<Int, Int, Int>>()
    repeat(m) {
        st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        edges.add(Triple(a, b, c))
    }

    if (n < 3) return print(0)

    edges.sortBy { it.third }
    parentOf = IntArray(size = n + 1) { it }
    var minCost = 0L

    for ((a, b, c) in edges) {
        if (isCycleCreatedBy(a, b)) continue

        minCost += c
        if (--n < 3) break
    }

    print(minCost)
}

private fun isCycleCreatedBy(a: Int, b: Int): Boolean {
    val parentOfA = find(a)
    val parentOfB = find(b)
    if (parentOfA == parentOfB) return true

    if (parentOfA < parentOfB) {
        parentOf[parentOfB] = parentOfA
    } else {
        parentOf[parentOfA] = parentOfB
    }

    return false
}

private fun find(a: Int): Int =
    if (parentOf[a] == a) a else find(parentOf[a]).also { parentOf[a] = it }
