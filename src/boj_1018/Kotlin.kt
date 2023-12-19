package boj_1018

import java.util.StringTokenizer
import kotlin.math.min

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val colors = Array(n) { Array(m) { ' ' } }
    repeat(n) { row ->
        val input = readln()
        repeat(m) { col ->
            colors[row][col] = input[col]
        }
    }

    var minRedrawCount = Int.MAX_VALUE
    for (startRow in 0..n) {
        if (n < startRow + 8) break

        for (startCol in 0..m) {
            if (m < startCol + 8) break

            var whiteStartRedrawCount = 0
            for (row in startRow until startRow + 8) {
                for (col in startCol until startCol + 8) {
                    if (row % 2 == 0) {
                        if (col % 2 == 0) {
                            if (colors[row][col] != 'W') ++whiteStartRedrawCount
                        } else {
                            if (colors[row][col] == 'W') ++whiteStartRedrawCount
                        }
                    } else {
                        if (col % 2 == 0) {
                            if (colors[row][col] == 'W') ++whiteStartRedrawCount
                        } else {
                            if (colors[row][col] != 'W') ++whiteStartRedrawCount
                        }
                    }
                }
            }

            val blackStartRedrawCount = 64 - whiteStartRedrawCount
            minRedrawCount = min(minRedrawCount, min(whiteStartRedrawCount, blackStartRedrawCount))
        }
    }

    println(minRedrawCount)
}
