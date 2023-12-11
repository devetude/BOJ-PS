package boj_25305

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val scores = IntArray(n)
    st = StringTokenizer(readln())
    repeat(n) { scores[it] = st.nextToken().toInt() }

    scores.sortDescending()
    val cutLineScore = scores[k - 1]

    println(cutLineScore)
}
