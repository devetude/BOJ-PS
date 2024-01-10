package boj_17271

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val counts = IntArray(size = 10_001)
    counts[0] = 1
    for (i in 1..n) {
        counts[i] = counts[i - 1] % 1_000_000_007
        if (m <= i) counts[i] += counts[i - m] % 1_000_000_007
    }

    print(counts[n] % 1_000_000_007)
}
