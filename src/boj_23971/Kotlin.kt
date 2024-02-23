package boj_23971

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val h = st.nextToken().toInt()
    val w = st.nextToken().toInt()
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    print(availableSize(h, n) * availableSize(w, m))
}

fun availableSize(length: Int, space: Int): Int {
    val unit = space + 1
    val quotient = length / unit

    return if (unit * quotient == length) quotient else quotient + 1
}
