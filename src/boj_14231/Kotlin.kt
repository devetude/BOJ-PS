package boj_14231

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val sizes = IntArray(n)
    val maxCounts = IntArray(n)
    var maxCount = 0
    repeat(n) {
        sizes[it] = st.nextToken().toInt()
        maxCounts[it] = 1
        for (i in 0..<it) {
            if (sizes[i] < sizes[it]) {
                maxCounts[it] = max(maxCounts[it], b = maxCounts[i] + 1)
            }
        }
        maxCount = max(maxCount, maxCounts[it])
    }

    print(maxCount)
}
