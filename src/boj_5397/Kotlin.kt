package boj_5397

import java.util.Stack

fun main() {
    System.out.bufferedWriter().use { bw ->
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

            for (i in leftStack.indices) bw.write(leftStack[i].toString())
            while (rightStack.isNotEmpty()) bw.write(rightStack.pop().toString())
            bw.write("\n")
        }

        bw.flush()
    }
}
