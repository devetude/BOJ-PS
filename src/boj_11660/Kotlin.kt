package boj_11660

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val map = Array(size = n + 1) { IntArray(size = n + 1) }
    for (row in 1..n) {
        st = StringTokenizer(readln())
        for (col in 1..n) {
            map[row][col] = st.nextToken().toInt() +
                    if (1 < col) map[row][col - 1] else map[row - 1][n]
        }
    }

    System.out.bufferedWriter().use { bw ->
        repeat(m) {
            st = StringTokenizer(readln())
            val x1 = st.nextToken().toInt()
            val y1 = st.nextToken().toInt()
            val x2 = st.nextToken().toInt()
            val y2 = st.nextToken().toInt()

            var sum = 0
            for (x in x1..x2) {
                sum += map[x][y2] - if (1 < y1) map[x][y1 - 1] else map[x - 1][n]
            }

            bw.write(sum.toString())
            bw.write("\n")
        }

        bw.flush()
    }
}
