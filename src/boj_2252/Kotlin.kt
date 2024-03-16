package boj_2252

import java.util.LinkedList
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

    val nextNodes = LinkedList<Int>().apply {
        for (u in 1..n) if (indegreeOf[u] == 0) offer(u)
    }
    val resultBuilder = StringBuilder()
    while (nextNodes.isNotEmpty()) {
        val u = nextNodes.poll()
        resultBuilder.append(u, ' ')

        adjacencyList[u].forEach { v ->
            --indegreeOf[v]
            if (indegreeOf[v] == 0) nextNodes.offer(v)
        }
    }

    System.out.bufferedWriter().use {
        it.write(resultBuilder.toString())
        it.flush()
    }
}
