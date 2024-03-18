package boj_1766

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val adjacencyList = Array(size = n + 1) { LinkedList<Int>() }
    val indegreeOf = IntArray(size = n + 1)
    repeat(m) {
        st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        adjacencyList[a].add(b)
        ++indegreeOf[b]
    }

    val nextNodes = PriorityQueue<Int>()
    for (a in 1..n) if (indegreeOf[a] == 0) nextNodes.offer(a)

    val sb = StringBuilder()
    while (nextNodes.isNotEmpty()) {
        val a = nextNodes.poll()
        sb.append(a, ' ')

        adjacencyList[a].forEach { b -> if (--indegreeOf[b] == 0) nextNodes.offer(b) }
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
