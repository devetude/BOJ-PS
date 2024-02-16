package boj_15964

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()

    print(a * a - b * b)
}
