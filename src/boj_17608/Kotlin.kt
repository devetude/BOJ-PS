package boj_17608

import java.util.Stack

fun main() {
    val n = readln().toInt()

    val heights = IntArray(n)
    repeat(n) { heights[it] = readln().toInt() }

    val stack = Stack<Int>()
    stack.push(heights.last())
    for (i in heights.lastIndex - 1 downTo 0) {
        if (stack.isNotEmpty() && stack.peek() < heights[i]) stack.push(heights[i])
    }

    print(stack.size)
}
