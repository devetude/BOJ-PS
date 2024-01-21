package boj_4949

import java.util.Stack

fun main() {
    val result = buildString {
        var line: String
        while (readln().also { line = it } != ".") {
            val stack = Stack<Char>()
            for (c in line) {
                when (c) {
                    '(', '[' -> stack.push(c)

                    ')' -> {
                        if (stack.isEmpty() || stack.peek() != '(') {
                            stack.push(c)
                            break
                        }
                        stack.pop()
                    }

                    ']' -> {
                        if (stack.isEmpty() || stack.peek() != '[') {
                            stack.push(c)
                            break
                        }
                        stack.pop()
                    }

                    else -> Unit
                }
            }
            appendLine(if (stack.isEmpty()) "yes" else "no")
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
