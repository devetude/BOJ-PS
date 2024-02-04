package boj_3151

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val a = IntArray(n) { st.nextToken().toInt() }.apply { sort() }

    var size = 0L
    for (left in 0..a.lastIndex - 2) {
        for (right in a.lastIndex downTo left + 2) {
            val value = (a[left] + a[right]).inv() + 1
            val from = left + 1
            size += a.upperBound(value, from, right) - a.lowerBound(value, from, right)
        }
    }

    print(size)
}

fun IntArray.lowerBound(value: Int, from: Int, to: Int): Int {
    var low = from
    var high = to
    while (low < high) {
        val mid = low + high shr 1
        if (this[mid] < value) low = mid + 1 else high = mid
    }

    return high
}

fun IntArray.upperBound(value: Int, from: Int, to: Int): Int {
    var low = from
    var high = to
    while (low < high) {
        val mid = low + high shr 1
        if (this[mid] <= value) low = mid + 1 else high = mid
    }

    return high
}
