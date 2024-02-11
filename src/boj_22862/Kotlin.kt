package boj_22862

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val s = IntArray(n) { st.nextToken().toInt() }

    var left = 0
    var right = 0
    var delete = 0
    var maxLen = 0
    while (left < n && right < n) {
        if (delete < k) {
            if (s[right].isOdd()) ++delete
        } else {
            if (s[right].isOdd()) {
                while (!s[left].isOdd()) ++left
                ++left
            }

            val len = right - left + 1 - delete
            if (maxLen < len) maxLen = len
        }
        ++right
    }
    val len = right - left - delete
    if (maxLen < len) maxLen = len

    print(maxLen)
}

fun Int.isOdd(): Boolean = this and 1 == 1
