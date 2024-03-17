package boj_1197

import java.util.StringTokenizer

private lateinit var parentOf: IntArray

fun main() {
    var st = StringTokenizer(readln())
    var v = st.nextToken().toInt()
    val e = st.nextToken().toInt()

    val edges = Array(e) {
        st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        Triple(a, b, c)
    }.apply { sortBy { it.third } }

    parentOf = IntArray(size = v + 1) { it }

    var minCostSum = 0
    for (i in edges.indices) {
        val (a, b, c) = edges[i]
        if (isCycleCreatedBy(a, b)) continue

        minCostSum += c
        if (--v <= 1) break
    }

    print(minCostSum)
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
