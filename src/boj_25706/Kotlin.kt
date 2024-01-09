package boj_25706

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val heights = IntArray(size = n + 1)
    repeat(n) { heights[it + 1] = st.nextToken().toInt() }

    val counts = LongArray(size = n + 1)
    counts[n] = 1
    for (i in n - 1 downTo 1) {
        val landingIdx = i + heights[i] + 1
        counts[i] = if (n < landingIdx) 1 else counts[landingIdx] + 1
    }

    System.out.bufferedWriter().use {
        for (i in 1..n) {
            it.write(counts[i].toString())
            it.write(" ")
        }

        it.flush()
    }
}
