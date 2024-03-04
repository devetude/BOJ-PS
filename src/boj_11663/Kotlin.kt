package boj_11663

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val points = IntArray(n) { st.nextToken().toInt() }.apply { sort() }

    val sb = StringBuilder()
    repeat(m) {
        st = StringTokenizer(readln())
        val start = st.nextToken().toInt()
        val end = st.nextToken().toInt()

        val startLowerBound = points.lowerBound(start)
        val endUpperBound = points.upperBound(end)
        sb.appendLine(value = endUpperBound - startLowerBound)
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
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

private fun IntArray.upperBound(value: Int): Int {
    var low = 0
    var high = size
    while (low < high) {
        val mid = low + high shr 1
        if (this[mid] <= value) low = mid + 1 else high = mid
    }

    return high
}
