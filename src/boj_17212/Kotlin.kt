package boj_17212

fun main() {
    val n = readln().toInt()
    val coinUnits = intArrayOf(1, 2, 5, 7)

    val minCoinCounts = IntArray(size = n + 1)
    for (i in 1..n) {
        minCoinCounts[i] = coinUnits.minOf { coinUnit ->
            if (coinUnit <= i) minCoinCounts[i - coinUnit] + 1 else Int.MAX_VALUE
        }
    }

    print(minCoinCounts[n])
}
