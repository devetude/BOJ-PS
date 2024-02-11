package boj_2230

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val a = IntArray(n) { readln().toInt() }.apply { sort() }

    var left = 0
    var right = 0
    var minDiff = Int.MAX_VALUE
    while (left < n && right < n) {
        val diff = a[right] - a[left]
        if (diff < m) {
            ++right
        } else {
            if (diff < minDiff) minDiff = diff

            ++left
            if (right < left) right = left
        }
    }

    print(minDiff)
}
