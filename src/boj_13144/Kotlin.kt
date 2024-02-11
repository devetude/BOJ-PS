package boj_13144

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val a = IntArray(n) { st.nextToken().toInt() }

    var left = 0
    var right = 0
    val isVisited = BooleanArray(size = 100_001)
    var count = 0L
    while (left < n && right < n) {
        if (isVisited[a[right]]) {
            isVisited[a[left++]] = false
        } else {
            isVisited[a[right++]] = true
            count += right - left
        }
    }

    print(count)
}
