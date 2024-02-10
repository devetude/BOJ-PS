package boj_20922

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val a = IntArray(n) { st.nextToken().toInt() }

    val counts = IntArray(size = 100_001)
    var left = 0
    var right = 0
    var maxLen = 1
    while (left < n && right < n) {
        if (counts[a[right]] + 1 <= k) {
            val len = right - left + 1
            if (maxLen < len) maxLen = len
            ++counts[a[right++]]
        } else {
            while (a[left] != a[right]) --counts[a[left++]]
            --counts[a[left++]]
        }
    }

    print(maxLen)
}
