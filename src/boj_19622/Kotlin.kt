package boj_19622

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val n = readln().toInt()

    val counts = IntArray(n)
    repeat(n) {
        val st = StringTokenizer(readln())
        repeat(times = 2) { st.nextToken() }
        counts[it] = st.nextToken().toInt()
    }

    val maxCounts = IntArray(n)
    maxCounts[0] = counts[0]
    if (n < 2) return print(maxCounts[0])

    maxCounts[1] = max(maxCounts[0], counts[1])
    for (i in 2 until n) {
        maxCounts[i] = max(maxCounts[i - 1], b = maxCounts[i - 2] + counts[i])
    }

    print(maxCounts.last())
}
