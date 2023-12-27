package boj_11501

import java.util.StringTokenizer

fun main() {
    val t = readln().toInt()
    val result = buildString {
        repeat(t) {
            val n = readln().toInt()
            val st = StringTokenizer(readln())
            val values = LongArray(n)
            repeat(n) { values[it] = st.nextToken().toLong() }

            var maxProfit = 0L
            var maxValue = Long.MIN_VALUE
            for (i in values.lastIndex downTo 0) {
                val value = values[i]
                if (maxValue <= value) {
                    maxValue = value
                    continue
                }

                maxProfit += maxValue - value
            }

            appendLine(maxProfit)
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
