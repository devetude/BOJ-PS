package boj_10423

import java.util.StringTokenizer

private lateinit var parentOf: IntArray

fun main() {
    var st = StringTokenizer(readln())
    var n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val edges = mutableListOf<Triple<Int, Int, Int>>()
    st = StringTokenizer(readln())
    repeat(k) {
        val v = st.nextToken().toInt()
        val edge = Triple(first = 0, v, third = 0)
        edges.add(edge)
    }
    repeat(m) {
        st = StringTokenizer(readln())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        val edge = Triple(u, v, w)
        edges.add(edge)
    }
    edges.sortBy { it.third }

    parentOf = IntArray(size = n + 1) { it }

    var minWeight = 0
    for (i in edges.indices) {
        val (u, v, w) = edges[i]
        if (isCycleCreatedBy(u, v)) continue

        minWeight += w
        if (--n < 1) break
    }

    print(minWeight)
}

private fun isCycleCreatedBy(u: Int, v: Int): Boolean {
    val parentOfU = find(u)
    val parentOfV = find(v)
    if (parentOfU == parentOfV) return true

    if (parentOfU < parentOfV) {
        parentOf[parentOfV] = parentOfU
    } else {
        parentOf[parentOfU] = parentOfV
    }

    return false
}

private fun find(u: Int): Int =
    if (parentOf[u] == u) u else find(parentOf[u]).also { parentOf[u] = it }
