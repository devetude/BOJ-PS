package boj_2828

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val j = readln().toInt()

    var start = 1
    var minMoves = 0
    repeat(j) {
        val x = readln().toInt()
        val end = start + m - 1
        when {
            x < start -> {
                minMoves += start - x
                start = x
            }

            end < x -> {
                val moves = x - end
                minMoves += moves
                start += moves
            }

            else -> Unit
        }
    }

    println(minMoves)
}
