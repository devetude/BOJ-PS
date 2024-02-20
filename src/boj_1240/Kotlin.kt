package boj_1240

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val adjacencyList = Array<LinkedList<Pair<Int, Int>>>(size = n + 1) { LinkedList() }
    repeat(times = n - 1) {
        st = StringTokenizer(readln())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        adjacencyList[u].add(v to w)
        adjacencyList[v].add(u to w)
    }

    val sb = StringBuilder()
    repeat(m) {
        st = StringTokenizer(readln())
        val s = st.nextToken().toInt()
        val e = st.nextToken().toInt()

        val weights = IntArray(size = n + 1) { Int.MIN_VALUE }.apply { this[s] = 0 }
        val nodes = LinkedList<Int>().apply { offer(s) }
        while (nodes.isNotEmpty()) {
            val u = nodes.poll()
            if (u == e) break

            adjacencyList[u].forEach { (v, w) ->
                if (weights[v] != Int.MIN_VALUE) return@forEach

                weights[v] = weights[u] + w
                nodes.offer(v)
            }
        }

        sb.appendLine(weights[e])
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
