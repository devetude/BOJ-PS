package boj_1629

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    print(a.pow(b, c))
}

fun Long.pow(e: Int, mod: Int): Long {
    if (e == 1) return this % mod

    val tmp = pow(e = e shr 1, mod)
    val squareModOfTmp = tmp * tmp % mod

    return if (e and 1 == 1) squareModOfTmp * this % mod else squareModOfTmp
}
