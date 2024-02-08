package boj_2143

import java.util.StringTokenizer

fun main() {
    val t = readln().toInt()

    val n = readln().toInt()
    var st = StringTokenizer(readln())
    var acc = 0L
    val a = LongArray(n) { acc += st.nextToken().toLong(); acc }

    val m = readln().toInt()
    st = StringTokenizer(readln())
    acc = 0L
    val b = LongArray(m) { acc += st.nextToken().toLong(); acc }

    val aSubSums = a.toSubSums()
    val bSubSums = b.toSubSums().apply { sort() }

    var count = 0L
    aSubSums.forEach { aSubSum ->
        val bSubSum = t - aSubSum
        count += bSubSums.upperBound(bSubSum) - bSubSums.lowerBound(bSubSum)
    }

    print(count)
}

fun LongArray.toSubSums(): MutableList<Long> {
    val subSums = mutableListOf<Long>()
    for (left in -1 until size) {
        for (right in lastIndex downTo left + 1) {
            subSums.add(this[right] - if (-1 < left) this[left] else 0L)
        }
    }

    return subSums
}

fun List<Long>.lowerBound(value: Long): Int {
    var low = 0
    var high = size
    while (low < high) {
        val mid = low + high shr 1
        if (this[mid] < value) low = mid + 1 else high = mid
    }

    return high
}

fun List<Long>.upperBound(value: Long): Int {
    var low = 0
    var high = size
    while (low < high) {
        val mid = low + high shr 1
        if (this[mid] <= value) low = mid + 1 else high = mid
    }

    return high
}
