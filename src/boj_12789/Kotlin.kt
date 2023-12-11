package boj_12789

import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    if (n == 1) return println("Nice")

    val stack = Stack<Int>()
    var rank = 1
    repeat(n) {
        while (stack.isNotEmpty() && stack.peek() == rank) {
            stack.pop()
            ++rank
        }
        val next = st.nextToken().toInt()
        if (next == rank) ++rank else stack.push(next)
    }
    while (stack.isNotEmpty() && stack.peek() == rank) {
        stack.pop()
        ++rank
    }

    println(if (stack.isEmpty()) "Nice" else "Sad")
}
