package boj_10828

import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val result = buildString {
        val stack = Stack<String>()
        repeat(readln().toInt()) {
            val st = StringTokenizer(readln())
            val cmd = st.nextToken()
            when {
                cmd[1] == 'u' -> stack.push(st.nextToken())
                cmd[0] == 't' -> appendLine(stack.topOrMinus1())
                cmd[0] == 's' -> appendLine(stack.size)
                cmd[0] == 'e' -> appendLine(stack.isEmptyToInt())
                else -> appendLine(stack.popOrMinus1())
            }
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}

fun Stack<String>.popOrMinus1(): String = if (isNotEmpty()) pop() else "-1"

fun Stack<String>.isEmptyToInt(): Int = if (isEmpty()) 1 else 0

fun Stack<String>.topOrMinus1(): String = if (isNotEmpty()) peek() else "-1"
