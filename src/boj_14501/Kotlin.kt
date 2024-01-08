package boj_14501

import java.util.StringTokenizer
import kotlin.math.max

var maxProfit = 0

fun main() {
    val n = readln().toInt()
    val t = IntArray(size = n + 1)
    val p = IntArray(size = n + 1)
    repeat(n) {
        val day = it + 1
        val st = StringTokenizer(readln())
        t[day] = st.nextToken().toInt()
        p[day] = st.nextToken().toInt()
    }

    for (startDay in 1..n) {
        val endDay = startDay + t[startDay] - 1
        if (n < endDay) continue

        dfs(n, t, p, startDay)
    }

    println(maxProfit)
}

fun dfs(lastDay: Int, t: IntArray, p: IntArray, startDay: Int, profit: Int = p[startDay]) {
    maxProfit = max(maxProfit, profit)

    for (nextStartDay in startDay + t[startDay]..lastDay) {
        val nextEndDay = nextStartDay + t[nextStartDay] - 1
        if (lastDay < nextEndDay) continue

        val nextProfit = profit + p[nextStartDay]
        dfs(lastDay, t, p, nextStartDay, nextProfit)
    }
}
