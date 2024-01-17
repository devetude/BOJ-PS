package boj_10807

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val v = readln()

    var count = 0
    repeat(n) { if (st.nextToken() == v) ++count }

    print(count)
}
