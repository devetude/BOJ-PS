package boj_11005

import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    var n = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    val stack = Stack<Char>()
    while (0 <= n) {
        val quotient = n / b
        val remainder = n % b
        stack.push(remainder.toBaseChar())
        n -= quotient * b
    }
    val result = buildString { while (stack.isNotEmpty()) append(stack.pop()) }

    println(result)
}

fun Int.toBaseChar(): Char =
    if (10 <= this) (this + 'A'.code - 10).toChar() else toChar() + '0'.code
