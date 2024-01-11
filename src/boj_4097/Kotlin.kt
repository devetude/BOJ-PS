package boj_4097

import kotlin.math.max

fun main() {
    System.out.bufferedWriter().use {
        while (true) {
            val n = readln().toInt()
            if (n == 0) return it.flush()

            var yesterdayMaxProfit = 0L
            var maxProfit = Long.MIN_VALUE
            for (day in 1..n) {
                val todayProfit = readln().toLong()
                val todayMaxProfit = max(a = yesterdayMaxProfit + todayProfit, todayProfit)
                yesterdayMaxProfit = todayMaxProfit
                maxProfit = max(maxProfit, todayMaxProfit)
            }

            it.write(maxProfit.toString())
            it.write("\n")
        }
    }
}
