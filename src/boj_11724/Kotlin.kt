package boj_11724

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val adjacencyList = Array(size = n + 1) { LinkedList<Int>() }
    repeat(m) {
        st = StringTokenizer(readln())
        val u = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        adjacencyList[u].add(v)
        adjacencyList[v].add(u)
    }

    val isVisited = BooleanArray(size = n + 1)
    var size = 0
    for (start in 1..n) {
        if (isVisited[start]) continue

        isVisited[start] = true
        val nextNodes = LinkedList<Int>().apply { offer(start) }
        while (nextNodes.isNotEmpty()) {
            val u = nextNodes.poll()

            adjacencyList[u].forEach { v ->
                if (isVisited[v]) return@forEach

                isVisited[v] = true
                nextNodes.offer(v)
            }
        }

        ++size
    }

    print(size)
}
