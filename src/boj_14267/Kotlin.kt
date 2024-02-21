package boj_14267

import java.util.LinkedList
import java.util.StringTokenizer

lateinit var childrenOf: Array<LinkedList<Int>>
lateinit var weights: IntArray

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readln())
    childrenOf = Array(size = n + 1) { LinkedList() }
    repeat(n) {
        val parent = st.nextToken().toInt()
        if (parent == -1) return@repeat

        val child = it + 1
        childrenOf[parent].add(child)
    }

    weights = IntArray(size = n + 1)
    repeat(m) {
        st = StringTokenizer(readln())
        val i = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        weights[i] += w
    }
    praiseChildren()

    val sb = StringBuilder()
    for (i in 1..n) sb.append(weights[i], ' ')

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

fun praiseChildren(parent: Int = 1) {
    childrenOf[parent].forEach { child ->
        weights[child] += weights[parent]
        praiseChildren(child)
    }
}
