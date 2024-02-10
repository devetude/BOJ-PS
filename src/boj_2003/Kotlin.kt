package boj_2003

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    st = StringTokenizer(readln())
    var acc = 0
    val subSums = IntArray(n) { acc += st.nextToken().toInt(); acc }

    var left = 0
    var right = 0
    var count = 0
    while (left < n && right < n) {
        val sum = subSums[right] - if (0 < left) subSums[left - 1] else 0
        if (sum < m) {
            ++right
        } else {
            ++left
            if (right < left) right = left
            if (sum == m) ++count
        }
    }

    print(count)
}
