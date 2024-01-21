package boj_9012

import java.util.Stack

fun main() {
    val result = buildString {
        repeat(readln().toInt()) {
            val stack = Stack<Char>()
            mainLoop@ for (c in readln()) {
                if (c == '(') {
                    stack.push(c)
                    continue
                }

                while (stack.isNotEmpty()) if (stack.pop() == '(') continue@mainLoop

                stack.push(c)
                break
            }
            appendLine(if (stack.isEmpty()) "YES" else "NO")
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
