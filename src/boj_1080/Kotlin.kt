package boj_1080

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val a = Array(n) { BooleanArray(m) }
    for (row in 0 until n) {
        val line = readln()
        for (col in 0 until m) {
            a[row][col] = line[col] == '1'
        }
    }

    val b = Array(n) { BooleanArray(m) }
    for (row in 0 until n) {
        val line = readln()
        for (col in 0 until m) {
            b[row][col] = line[col] == '1'
        }
    }

    var changedCount = 0
    for (startRow in 0..n - 3) {
        for (startCol in 0..m - 3) {
            var shouldChange = false
            if (a[startRow][startCol] != b[startRow][startCol]) {
                shouldChange = true
            }
            if (!shouldChange) continue

            for (row in startRow until startRow + 3) {
                for (col in startCol until startCol + 3) {
                    a[row][col] = !a[row][col]
                }
            }
            ++changedCount
        }
    }

    for (row in 0 until n) {
        for (col in 0 until m) {
            if (a[row][col] != b[row][col]) return println(-1)
        }
    }
    println(changedCount)
}
