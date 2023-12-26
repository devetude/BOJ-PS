package boj_2812

import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val numberStr = readln()

    val stack = Stack<Char>()
    var removedCount = 0
    for (i in 0 until n) {
        val numberChar = numberStr[i]
        while (stack.isNotEmpty() && stack.peek() < numberChar && removedCount < k) {
            stack.pop()
            ++removedCount
        }

        stack.push(numberChar)
    }

    println(stack.subList(0, n - k).joinToString(separator = ""))
}
