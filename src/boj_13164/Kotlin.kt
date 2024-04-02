package boj_13164

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val heightOf = IntArray(n) { st.nextToken().toInt() }

    val diffs = IntArray(size = n - 1) { heightOf[it + 1] - heightOf[it] }.apply { sort() }
    var cost = 0
    for (i in 0 until n - k) cost += diffs[i]

    print(cost)
}
