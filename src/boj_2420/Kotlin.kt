package boj_2420

import java.util.StringTokenizer
import kotlin.math.abs

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toLong()
    val m = st.nextToken().toLong()

    print(abs(n = n - m))
}
