package boj_16562

import java.util.StringTokenizer

private lateinit var costOf: IntArray
private lateinit var parentOf: IntArray

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    st = StringTokenizer(readln())
    costOf = IntArray(size = n + 1)
    repeat(n) { costOf[it + 1] = st.nextToken().toInt() }

    parentOf = IntArray(size = n + 1) { it }
    repeat(m) {
        st = StringTokenizer(readln())
        val v = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        union(v, w)
    }

    val minCost = (1..n).asSequence()
        .map(::find)
        .distinct()
        .sumOf(costOf::get)
    if (k < minCost) return print("Oh no")

    print(minCost)
}

private fun union(v: Int, w: Int) {
    val parentOfV = find(v)
    val parentOfW = find(w)
    if (parentOfV == parentOfW) return

    if (costOf[parentOfV] < costOf[parentOfW]) {
        parentOf[parentOfW] = parentOfV
    } else {
        parentOf[parentOfV] = parentOfW
    }
}

private fun find(v: Int): Int =
    if (parentOf[v] == v) v else find(parentOf[v]).also { parentOf[v] = it }
