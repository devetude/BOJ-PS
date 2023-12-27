package boj_11497

import java.util.StringTokenizer
import kotlin.math.abs
import kotlin.math.max

fun main() {
    val t = readln().toInt()
    val result = buildString {
        repeat(t) {
            val n = readln().toInt()
            val st = StringTokenizer(readln())
            val heights = IntArray(n)
            repeat(n) { heights[it] = st.nextToken().toInt() }

            heights.sort()
            var maxDiff = heights[1] - heights.first()
            for (i in 2 until n) {
                val diff = abs(n = heights[i] - heights[i - 2])
                maxDiff = max(maxDiff, diff)
            }
            appendLine(maxDiff)
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
