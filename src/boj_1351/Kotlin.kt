package boj_1351

import java.util.StringTokenizer

var p: Int = 0
var q: Int = 0

val a: HashMap<Long, Long> = HashMap<Long, Long>().apply { this[0L] = 1L }

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toLong()
    p = st.nextToken().toInt()
    q = st.nextToken().toInt()

    print(dp(n))
}

fun dp(i: Long): Long = a[i] ?: (dp(i = i / p) + dp(i = i / q)).also { a[i] = it }
