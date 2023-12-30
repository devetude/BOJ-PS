package boj_11725

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val graph = Array(size = n + 1) { LinkedList<Int>() }
    repeat(times = n - 1) {
        val st = StringTokenizer(readln())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        graph[start].add(end)
        graph[end].add(start)
    }
    val queue = LinkedList<Int>()
    queue.offer(1)
    val parents = IntArray(size = n + 1)
    while (queue.isNotEmpty()) {
        val current = queue.poll()

        graph[current].forEach { next ->
            if (0 < parents[next]) return@forEach

            parents[next] = current
            queue.offer(next)
        }
    }
    val result = buildString {
        for (child in 2..n) appendLine(parents[child])
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
