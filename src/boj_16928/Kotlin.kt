package boj_16928

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val ladders = IntArray(size = 101)

    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    repeat(times = n + m) {
        st = StringTokenizer(readln())
        ladders[st.nextToken().toInt()] = st.nextToken().toInt()
    }

    val queue = LinkedList<Int>()
    queue.add(1)
    val visitCounts = IntArray(size = 101)
    while (queue.isNotEmpty()) {
        val start = queue.poll()
        if (start == 100) return println(visitCounts[100])

        for (dice in 1..6) {
            val end = start + dice
            if (100 < end) continue

            val ladderEnd = ladders[end]
            if (ladderEnd == 0) {
                if (0 < visitCounts[end]) continue

                visitCounts[end] = visitCounts[start] + 1
                queue.offer(end)
            } else {
                if (0 < visitCounts[ladderEnd]) continue

                visitCounts[ladderEnd] = visitCounts[start] + 1
                queue.offer(ladderEnd)
            }
        }
    }
}
