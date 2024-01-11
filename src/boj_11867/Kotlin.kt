package boj_11867

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    print(if (n and m and 1 == 1) "B" else "A")
}
