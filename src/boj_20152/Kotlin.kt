package boj_20152

import java.util.StringTokenizer
import kotlin.math.abs

fun main() {
    val st = StringTokenizer(readln())
    val h = st.nextToken().toInt()
    val n = st.nextToken().toInt()

    val size = abs(n = h - n) + 1
    val map = Array(size = size + 1) { LongArray(size = size + 1) }
    map[1][1] = 1L
    for (row in 1..size) {
        for (col in 1..size) {
            if (row == 1 && col == 1) continue
            if (row < col) continue

            map[row][col] = map[row - 1][col] + map[row][col - 1]
        }
    }

    print(map[size][size])
}
