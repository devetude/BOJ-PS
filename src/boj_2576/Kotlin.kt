package boj_2576

import kotlin.math.min

fun main() {
    var sum = 0
    var minValue = 100
    repeat(times = 7) {
        val n = readln().toInt()
        if (n and 1 == 0) return@repeat

        sum += n
        minValue = min(minValue, n)
    }
    if (sum < 1) return print(-1)

    print("$sum\n$minValue")
}
