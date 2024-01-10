package boj_16493

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val requiredDays = IntArray(size = m + 1)
    val pages = IntArray(size = m + 1)
    repeat(m) {
        val num = it + 1
        st = StringTokenizer(readln())
        requiredDays[num] = st.nextToken().toInt()
        pages[num] = st.nextToken().toInt()
    }

    val maxPages = Array(size = m + 1) { IntArray(size = n + 1) }
    for (i in 1..m) {
        for (j in 1..n) {
            maxPages[i][j] = if (j < requiredDays[i]) {
                maxPages[i - 1][j]
            } else {
                max(a = maxPages[i - 1][j - requiredDays[i]] + pages[i], maxPages[i - 1][j])
            }
        }
    }

    print(maxPages[m][n])
}
