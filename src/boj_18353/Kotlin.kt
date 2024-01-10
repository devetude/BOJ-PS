package boj_18353

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val powers = IntArray(size = n + 1)
    repeat(n) { powers[it + 1] = st.nextToken().toInt() }

    val maxSizes = IntArray(size = n + 1)
    var maxSize = 0
    for (i in 1..n) {
        maxSizes[i] = 1
        for (j in 1..<i) {
            if (powers[i] < powers[j]) {
                maxSizes[i] = max(maxSizes[i], b = maxSizes[j] + 1)
            }
        }
        maxSize = max(maxSize, maxSizes[i])
    }

    print(n - maxSize)
}
