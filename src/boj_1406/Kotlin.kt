package boj_1406

import java.io.DataInputStream
import java.util.Stack
import java.util.StringTokenizer

fun main() {
    val leftStack = Stack<Char>()
    val rightStack = Stack<Char>()
    val dis = DataInputStream(System.`in`)
    while (true) {
        val c = dis.readByte().toInt().toChar()
        if (c == '\n') break
        leftStack.push(c)
    }

    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        when (st.nextToken().first()) {
            'L' -> if (leftStack.isNotEmpty()) rightStack.push(leftStack.pop())
            'D' -> if (rightStack.isNotEmpty()) leftStack.push(rightStack.pop())
            'B' -> if (leftStack.isNotEmpty()) leftStack.pop()
            else -> leftStack.push(st.nextToken().first())
        }
    }

    val result = buildString {
        leftStack.forEach(::append)
        for (i in rightStack.lastIndex downTo 0) append(rightStack[i])
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
    dis.close()
}
