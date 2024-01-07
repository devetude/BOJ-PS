package boj_15489

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val r = st.nextToken().toInt()
    val c = st.nextToken().toInt()
    val w = st.nextToken().toInt()

    val values = Array(size = r + w) { row ->
        IntArray(size = row + 1) { col ->
            if (col == 1 || col == row) 1 else 0
        }
    }

    for (row in 3 until values.size) {
        for (col in 2..<row) {
            values[row][col] = values[row - 1][col - 1] + values[row - 1][col]
        }
    }

    var sum = 0
    for (row in r until r + w) {
        for (col in c..c + row - r) {
            sum += values[row][col]
        }
    }

    print(sum)
}
