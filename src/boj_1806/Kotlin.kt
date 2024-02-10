package boj_1806

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val s = st.nextToken().toLong()

    st = StringTokenizer(readln())
    var acc = 0L
    val subSums = LongArray(n) { acc += st.nextToken().toLong(); acc }

    var left = 0
    var right = 0
    var minLen = Int.MAX_VALUE
    while (left < n && right < n) {
        val sum = subSums[right] - if (0 < left) subSums[left - 1] else 0L
        if (sum < s) {
            ++right
        } else {
            val len = right - left + 1
            if (len < minLen) minLen = len

            ++left
            if (right < left) right = left
        }
    }

    val result = if (minLen == Int.MAX_VALUE) 0 else minLen
    print(result)
}
