package boj_4803

import java.util.StringTokenizer

lateinit var parents: IntArray

fun main() {
    val sb = StringBuilder()
    var case = 1
    while (true) {
        var st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        val m = st.nextToken().toInt()
        if (n == 0 && m == 0) break

        parents = IntArray(size = n + 1) { it }
        repeat(m) {
            st = StringTokenizer(readln())
            val u = st.nextToken().toInt()
            val v = st.nextToken().toInt()
            uniteParentsBetween(u, v)
        }

        val roots = buildSet {
            for (u in 1..n) {
                val parent = parentOf(u)
                if (0 < parent) add(parent)
            }
        }
        val treeSize = roots.size

        sb.append("Case ", case++, ": ")
        when {
            1 < treeSize -> sb.append("A forest of ", treeSize, " trees.")
            treeSize == 1 -> sb.append("There is one tree.")
            else -> sb.append("No trees.")
        }
        sb.appendLine()
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

fun parentOf(u: Int): Int {
    val parent = parents[u]
    if (parent == u) return u

    return parentOf(parent).also { parents[u] = it }
}

fun uniteParentsBetween(u: Int, v: Int) {
    val uParent = parentOf(u)
    val vParent = parentOf(v)
    when {
        uParent < vParent -> parents[vParent] = uParent
        vParent < uParent -> parents[uParent] = vParent
        else -> {
            parents[vParent] = uParent
            parents[uParent] = 0
        }
    }
}
