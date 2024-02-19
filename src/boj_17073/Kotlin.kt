package boj_17073

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val w = st.nextToken().toDouble()

    val degree = IntArray(size = n + 1)
    repeat(times = n - 1) {
        st = StringTokenizer(readln())
        val u = st.nextToken().toInt()
        ++degree[u]
        val v = st.nextToken().toInt()
        ++degree[v]
    }

    var leafSize = 0
    for (i in 2..n) if (degree[i] == 1) ++leafSize

    print(w / leafSize)
}
