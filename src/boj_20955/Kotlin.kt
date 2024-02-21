package boj_20955

import java.util.StringTokenizer

lateinit var parents: IntArray
var cycleSize: Int = 0

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    parents = IntArray(size = n + 1) { it }
    repeat(m) {
        st = StringTokenizer(readln())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        uniteParentsBetween(u, v)
    }

    val treeSize = buildSet { for (u in 1..n) add(parentOf(u)) }.size

    print(treeSize + cycleSize - 1)
}

fun uniteParentsBetween(u: Int, v: Int) {
    val uParent = parentOf(u)
    val vParent = parentOf(v)
    when {
        uParent < vParent -> parents[vParent] = uParent
        vParent < uParent -> parents[uParent] = vParent
        else -> ++cycleSize
    }
}

fun parentOf(u: Int): Int {
    val parent = parents[u]
    if (parent == u) return u

    return parentOf(parent).also { parents[u] = it }
}
