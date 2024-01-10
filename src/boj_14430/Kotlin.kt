package boj_14430

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val hasOre = Array(size = n + 1) { BooleanArray(size = m + 1) }
    repeat(n) { i ->
        st = StringTokenizer(readln())
        repeat(m) { j ->
            hasOre[i + 1][j + 1] = st.nextToken() == "1"
        }
    }

    val maxValues = Array(size = n + 1) { IntArray(size = m + 1) }
    for (row in 1..n) {
        for (col in 1..m) {
            val previousMaxValue = max(maxValues[row - 1][col], maxValues[row][col - 1])
            maxValues[row][col] = previousMaxValue + if (hasOre[row][col]) 1 else 0
        }
    }

    print(maxValues[n][m])
}
