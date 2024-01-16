package boj_1977

import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    var sum = 0
    var minValue = 10_000
    for (i in n..m) {
        if (i.isPerfectSquare()) {
            sum += i
            minValue = min(minValue, i)
        }
    }

    val result = if (0 < sum) "$sum\n$minValue" else "-1"
    print(result)
}

fun Int.isPerfectSquare(): Boolean {
    var start = 1
    var end = this
    var mid = start + end shr 1
    var quotient = this / mid

    while (start <= end) {
        when {
            quotient < mid -> {
                end = mid - 1
                mid = start + end shr 1
                quotient = this / mid
            }

            mid * mid == this -> return true

            else -> {
                start = mid + 1
                mid = start + end shr 1
                quotient = this / mid
            }
        }
    }

    return false
}
