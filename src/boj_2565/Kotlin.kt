package boj_2565

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val links = IntArray(size = 501)
    repeat(n) {
        val st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        links[a] = b
    }

    val maxCounts = IntArray(size = 501)
    var maxCount = 0
    var unlinkedCount = 0
    for (i in 1..500) {
        if (links[i] < 1) {
            ++unlinkedCount
            continue
        }

        maxCounts[i] = 1
        for (j in 1..<i) {
            if (0 < links[j] && links[j] < links[i]) {
                maxCounts[i] = max(maxCounts[i], b = maxCounts[j] + 1)
            }
        }
        maxCount = max(maxCount, maxCounts[i])
    }

    val result = 500 - unlinkedCount - maxCount
    print(result)
}
