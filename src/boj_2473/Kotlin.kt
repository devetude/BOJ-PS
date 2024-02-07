package boj_2473

import java.util.StringTokenizer
import kotlin.math.abs

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val values = LongArray(n) { st.nextToken().toLong() }.apply { sort() }

    var nearestZeroSum = Long.MAX_VALUE
    val resultValues = LongArray(size = 3)
    for (left in 0 until values.lastIndex) {
        for (right in values.lastIndex downTo left + 2) {
            val value = (values[left] + values[right]).inv() + 1L
            val lower = values.lowerBound(value, from = left + 1, to = right - 1)
            val mid = if (left < lower - 1) {
                if (abs(n = value - values[lower - 1]) <= abs(n = value - values[lower])) {
                    lower - 1
                } else {
                    lower
                }
            } else {
                lower
            }
            val sum = values[left] + values[mid] + values[right]
            if (abs(sum) < abs(nearestZeroSum)) {
                nearestZeroSum = sum
                resultValues[0] = values[left]
                resultValues[1] = values[mid]
                resultValues[2] = values[right]
            }
        }
    }

    print(resultValues.joinToString(separator = " "))
}

fun LongArray.lowerBound(value: Long, from: Int, to: Int): Int {
    var low = from
    var high = to
    while (low < high) {
        val mid = low + high shr 1
        if (this[mid] < value) low = mid + 1 else high = mid
    }

    return high
}
