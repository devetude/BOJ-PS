package boj_1654

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val k = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    val lengths = LongArray(k) { readln().toLong() }.apply { sort() }

    var minLength = 1L
    var maxLength = lengths.last()
    while (minLength <= maxLength) {
        val midLength = minLength + maxLength shr 1
        val lowerBound = lengths.lowerBound(midLength)
        var size = 0L
        for (i in lowerBound until k) size += lengths[i] / midLength

        if (size < n) maxLength = midLength - 1L else minLength = midLength + 1L
    }

    print(maxLength)
}

private fun LongArray.lowerBound(value: Long): Int {
    var low = 0
    var high = size
    while (low < high) {
        val mid = low + high shr 1
        if (this[mid] < value) low = mid + 1 else high = mid
    }

    return high
}
