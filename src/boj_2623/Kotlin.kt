package boj_2623

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val indegreeOf = IntArray(size = n + 1)
    val adjacencyList = Array(size = n + 1) { LinkedList<Int>() }
    repeat(m) {
        st = StringTokenizer(readln())
        var parent = 0
        repeat(st.nextToken().toInt()) {
            val child = st.nextToken().toInt()
            if (0 < parent) {
                adjacencyList[parent].add(child)
                ++indegreeOf[child]
            }

            parent = child
        }
    }

    val nextNodes = LinkedList<Int>().apply {
        for (u in 1..n) if (indegreeOf[u] == 0) offer(u)
    }
    val sequences = mutableListOf<Int>()
    while (nextNodes.isNotEmpty()) {
        val u = nextNodes.poll()
        sequences.add(u)

        adjacencyList[u].forEach { v ->
            --indegreeOf[v]
            if (indegreeOf[v] == 0) nextNodes.offer(v)
        }
    }

    val result = if (sequences.size < n) "0" else sequences.joinToString(separator = "\n")
    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
