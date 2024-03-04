package boj_19637

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val titleToValue = Array(n) {
        st = StringTokenizer(readln())
        st.nextToken() to st.nextToken().toInt()
    }

    val sb = StringBuilder()
    repeat(m) {
        val value = readln().toInt()
        sb.appendLine(titleToValue.lowerTitleOf(value))
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}

private fun Array<Pair<String, Int>>.lowerTitleOf(value: Int): String {
    var low = 0
    var high = size
    while (low < high) {
        val mid = low + high shr 1
        if (this[mid].second < value) low = mid + 1 else high = mid
    }

    return this[high].first
}

