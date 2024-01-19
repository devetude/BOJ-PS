package boj_2493

import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())

    val result = buildString {
        val stack = Stack<Pair<Int, Int>>()
        repeat(n) {
            val height = st.nextToken().toInt()
            while (stack.isNotEmpty() && stack.peek().second <= height) stack.pop()
            append(if (stack.isNotEmpty()) stack.peek().first else 0, ' ')
            stack.push(it + 1 to height)
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
