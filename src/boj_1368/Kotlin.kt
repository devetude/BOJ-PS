package boj_1368

import java.util.StringTokenizer

private lateinit var parentOf: IntArray

fun main() {
    var n = readln().toInt()

    val edges = mutableListOf<Triple<Int, Int, Int>>()
    repeat(n) { i -> edges.add(Triple(n, i, readln().toInt())) }
    for (i in 0 until n) {
        val st = StringTokenizer(readln())
        for (j in 0 until n) {
            val c = st.nextToken()
            if (i < j) edges.add(Triple(i, j, c.toInt()))
        }
    }
    edges.sortBy { it.third }

    parentOf = IntArray(++n) { it }
    var minCost = 0
    for (k in edges.indices) {
        val (i, j, c) = edges[k]
        if (isCycleCreatedBy(i, j)) continue

        minCost += c
        if (--n <= 1) break
    }

    print(minCost)
}

private fun isCycleCreatedBy(i: Int, j: Int): Boolean {
    val parentOfI = find(i)
    val parentOfJ = find(j)
    if (parentOfI == parentOfJ) return true

    if (parentOfI < parentOfJ) {
        parentOf[parentOfJ] = parentOfI
    } else {
        parentOf[parentOfI] = parentOfJ
    }

    return false
}

private fun find(i: Int): Int =
    if (parentOf[i] == i) i else find(parentOf[i]).also { parentOf[i] = it }
