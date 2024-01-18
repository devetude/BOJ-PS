package boj_5397

import java.util.Stack

fun main() {
    val result = buildString {
        repeat(readln().toInt()) {
            val leftStack = Stack<Char>()
            val rightStack = Stack<Char>()

            readln().forEach {
                when (it) {
                    '<' -> if (leftStack.isNotEmpty()) rightStack.push(leftStack.pop())
                    '>' -> if (rightStack.isNotEmpty()) leftStack.push(rightStack.pop())
                    '-' -> if (leftStack.isNotEmpty()) leftStack.pop()
                    else -> leftStack.push(it)
                }
            }

            leftStack.forEach(::append)
            for (i in rightStack.lastIndex downTo 0) append(rightStack[i])
            appendLine()
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
