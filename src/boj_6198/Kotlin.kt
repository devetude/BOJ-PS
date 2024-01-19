package boj_6198

import java.util.Stack

fun main() {
    val n = readln().toInt()
    val heights = IntArray(n) { readln().toInt() }

    val stack = Stack<Pair<Int, Int>>()
    var count = 0L
    for (i in n - 1 downTo 0) {
        while (stack.isNotEmpty() && stack.peek().second < heights[i]) stack.pop()
        count += (if (stack.isNotEmpty()) stack.peek().first else n) - i - 1
        stack.push(i to heights[i])
    }

    print(count)
}
