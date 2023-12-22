package boj_24445

import java.util.LinkedList
import java.util.StringTokenizer
import java.util.TreeSet

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val r = st.nextToken().toInt()
    val e = Array(size = n + 1) { TreeSet<Int>(compareByDescending { it }) }
    repeat(m) {
        st = StringTokenizer(readln())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()
        e[start].add(end)
        e[end].add(start)
    }

    val visitSequences = IntArray(size = n + 1)
    var visitIdx = 1
    val queue = LinkedList<Int>()
    visitSequences[r] = visitIdx
    queue.offer(r)
    while (queue.isNotEmpty()) {
        val start = queue.poll()
        e[start].forEach { end ->
            if (0 < visitSequences[end]) return@forEach

            visitSequences[end] = ++visitIdx
            queue.offer(end)
        }
    }
    val result = buildString { for (i in 1..n) appendLine(visitSequences[i]) }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
