package boj_25755

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val w = st.nextToken()
    val n = st.nextToken().toInt()

    val matrix = Array(n) { Array(n) { "" } }
    for (row in 0 until n) {
        st = StringTokenizer(readln())
        for (col in 0 until n) {
            val num = st.nextToken().toInt()
            matrix[row][col] = when (num) {
                2 -> "5"
                5 -> "2"
                1 -> "1"
                8 -> "8"
                else -> "?"
            }
        }
    }

    System.out.bufferedWriter().use {
        when (w) {
            "L", "R" -> {
                for (row in 0 until n) {
                    for (col in n - 1 downTo 0) {
                        it.write(matrix[row][col])
                        it.write(" ")
                    }
                    it.write("\n")
                }
            }

            else -> {
                for (row in n - 1 downTo 0) {
                    for (col in 0 until n) {
                        it.write(matrix[row][col])
                        it.write(" ")
                    }
                    it.write("\n")
                }
            }
        }

        it.flush()
    }
}
