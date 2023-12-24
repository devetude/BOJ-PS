package boj_14916

fun main() {
    var n = readln().toInt()

    var fiveCoinCount = n / 5
    n -= 5 * fiveCoinCount
    var twoCoinCount = n / 2
    n -= 2 * twoCoinCount

    val totalCoinCount = fiveCoinCount + twoCoinCount
    if (totalCoinCount == 0) return println(-1)

    if (0 < n) {
        if (fiveCoinCount == 0) return println(-1)

        --fiveCoinCount
        n += 5
        twoCoinCount += n / 2
    }

    println(fiveCoinCount + twoCoinCount)
}
