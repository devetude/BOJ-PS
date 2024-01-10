package boj_1535

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val n = readln().toInt()

    var st = StringTokenizer(readln())
    val healths = IntArray(size = n + 1)
    repeat(n) { healths[it + 1] = st.nextToken().toInt() }

    st = StringTokenizer(readln())
    val joys = IntArray(size = n + 1)
    repeat(n) { joys[it + 1] = st.nextToken().toInt() }

    val maxJoys = Array(size = n + 1) { IntArray(size = 101) }
    for (i in 1..n) {
        for (j in 1..100) {
            maxJoys[i][j] = if (healths[i] <= j) {
                max(a = joys[i] + maxJoys[i - 1][j - healths[i]], maxJoys[i - 1][j])
            } else {
                maxJoys[i - 1][j]
            }
        }
    }

    print(maxJoys[n][99])
}
