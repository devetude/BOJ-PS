package boj_3009

import java.util.StringTokenizer

fun main() {
    var x = 0
    var y = 0
    repeat(times = 3) {
        val st = StringTokenizer(readln())
        x = x xor st.nextToken().toInt()
        y = y xor st.nextToken().toInt()
    }

    println("$x $y")
}
