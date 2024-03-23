package boj_16398

import java.util.StringTokenizer

private lateinit var parentOf: IntArray

fun main() {
    var n = readln().toInt()

    val edges = mutableListOf<Triple<Int, Int, Int>>()
    repeat(n) { i ->
        val st = StringTokenizer(readln())
        repeat(n) { j ->
            val w = st.nextToken().toInt()
            if (i < j) edges.add(Triple(i, j, w))
        }
    }
    edges.sortBy { it.third }

    parentOf = IntArray(n) { it }
    var minWeight = 0L
    for ((i, j, w) in edges) {
        if (isCycleCreatedBy(i, j)) continue

        minWeight += w
        if (--n < 2) break
    }

    print(minWeight)
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
