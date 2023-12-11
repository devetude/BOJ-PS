package boj_12015

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())

    val arr = IntArray(n)
    var lastIdx = -1
    while (st.hasMoreTokens()) {
        val a = st.nextToken().toInt()

        if (lastIdx < 0 || arr[lastIdx] < a) {
            arr[++lastIdx] = a
            continue
        }

        if (arr[lastIdx] == a) continue

        var idx = arr.binarySearch(a, toIndex = lastIdx + 1)
        if (idx < 0) idx = -idx - 1
        arr[idx] = a
    }

    println(lastIdx + 1)
}
