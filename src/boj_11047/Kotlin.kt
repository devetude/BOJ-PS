package boj_11047

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    var k = st.nextToken().toInt()

    val coins = IntArray(n) { readln().toInt() }

    var size = 0
    while (0 < k) {
        val i = coins.lowerBound(k).coerceAtMost(coins.lastIndex)
        val coin = if (k < coins[i]) coins[i - 1] else coins[i]
        with(k / coin) {
            size += this
            k -= this * coin
        }
    }

    print(size)
}

private fun IntArray.lowerBound(value: Int): Int {
    var low = 0
    var high = size
    while (low < high) {
        val mid = low + high shr 1
        if (this[mid] < value) low = mid + 1 else high = mid
    }

    return high
}
