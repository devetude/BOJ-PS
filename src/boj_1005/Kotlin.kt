package boj_1005

import java.util.LinkedList
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val t = readln().toInt()
    val sb = StringBuilder()
    repeat(t) {
        var st = StringTokenizer(readln())
        val n = st.nextToken().toInt()
        val k = st.nextToken().toInt()

        val durations = IntArray(size = n + 1)
        st = StringTokenizer(readln())
        repeat(n) { durations[it + 1] = st.nextToken().toInt() }

        val graph = Array(size = n + 1) { LinkedList<Int>() }
        val indegrees = IntArray(size = n + 1)
        repeat(k) {
            st = StringTokenizer(readln())
            val x = st.nextToken().toInt()
            val y = st.nextToken().toInt()
            graph[x].add(y)
            ++indegrees[y]
        }

        val w = readln().toInt()

        val nextNumbers = LinkedList<Int>()
        for (number in 1..n) {
            if (indegrees[number] == 0) nextNumbers.offer(number)
        }

        val durationSums = IntArray(size = n + 1) { durations[it] }
        while (nextNumbers.isNotEmpty()) {
            val currentNumber = nextNumbers.poll()

            graph[currentNumber].forEach { nextNumber ->
                durationSums[nextNumber] = max(
                    durationSums[nextNumber],
                    b = durationSums[currentNumber] + durations[nextNumber]
                )
                if (--indegrees[nextNumber] == 0) nextNumbers.offer(nextNumber)
            }
        }

        sb.appendLine(durationSums[w])
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
