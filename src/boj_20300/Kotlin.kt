package boj_20300

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val loss = LongArray(n) { st.nextToken().toLong() }.apply { sort() }

    var m = if (n and 1 == 0) 0L else loss.last()
    var left = 0
    var right = n - if (n and 1 == 0) 1 else 2
    while (left < right) m = maxOf(m, b = loss[left++] + loss[right--])

    print(m)
}
