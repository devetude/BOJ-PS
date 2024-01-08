package boj_14494

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val map = Array(size = n + 1) { row ->
        LongArray(size = m + 1) { col ->
            if (row == 1 || col == 1) 1 else 0
        }
    }

    for (i in 2..n) {
        for (j in 2..m) {
            map[i][j] = (map[i - 1][j - 1] + map[i - 1][j] + map[i][j - 1]) % 1_000_000_007
        }
    }

    print(map[n][m])
}
