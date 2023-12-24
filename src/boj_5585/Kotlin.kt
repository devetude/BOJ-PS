package boj_5585

val COINS = arrayOf(500, 100, 50, 10, 5, 1)

fun main() {
    val cost = readln().toInt()

    var change = 1_000 - cost
    var totalCoinCount = 0
    for (coin in COINS) {
        if (change == 0) break
        if (change < coin) continue

        val coinCount = change / coin
        change -= coin * coinCount
        totalCoinCount += coinCount
    }

    println(totalCoinCount)
}
