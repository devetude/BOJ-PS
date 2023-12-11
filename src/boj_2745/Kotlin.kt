package boj_2745

import java.util.StringTokenizer
import kotlin.math.pow

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken()
    val b = st.nextToken().toInt()

    // val result = n.toInt(b)
    var result = 0
    n.forEachIndexed { i, c -> result += b.pow(n = n.length - i - 1) * c.toBase10() }

    println(result)
}

private fun Char.toBase10(): Int =
    if ('A'.code <= code) code - 'A'.code + 10 else code - '0'.code

private fun Int.pow(n: Int): Int = toDouble().pow(n.toDouble()).toInt()
