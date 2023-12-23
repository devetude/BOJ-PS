package boj_11657

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val adjacentList = List(size = n + 1) { LinkedList<Vertex>() }
    repeat(m) {
        st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        adjacentList[a].add(Vertex(b, c))
    }

    val minDurations = LongArray(size = n + 1) { Long.MAX_VALUE }
    minDurations[1] = 0
    for (times in 1..n) {
        for (from in 1..n) {
            adjacentList[from].forEach { nextVertex ->
                val to = nextVertex.to
                if (minDurations[from] == Long.MAX_VALUE) return@forEach

                val nextDuration = minDurations[from] + nextVertex.duration
                if (minDurations[to] <= nextDuration) return@forEach

                minDurations[to] = nextDuration
                if (times == n) return println(-1)
            }
        }
    }
    val result = buildString {
        for (i in 2..n) {
            val minDuration = minDurations[i]
            if (minDuration == Long.MAX_VALUE) {
                appendLine(value = -1)
                continue
            }

            appendLine(minDuration)
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}

data class Vertex(val to: Int, val duration: Int)
