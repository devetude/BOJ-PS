package boj_12865

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val w = IntArray(size = n + 1)
    val v = IntArray(size = n + 1)
    repeat(n) {
        val num = it + 1
        st = StringTokenizer(readln())
        w[num] = st.nextToken().toInt()
        v[num] = st.nextToken().toInt()
    }

    val maxValues = Array(size = n + 1) { IntArray(size = k + 1) }
    for (i in 1..n) {
        for (j in 1..k) {
            maxValues[i][j] = if (j < w[i]) {
                maxValues[i - 1][j]
            } else {
                max(a = maxValues[i - 1][j - w[i]] + v[i], maxValues[i - 1][j])
            }
        }
    }

    print(maxValues[n][k])
}
