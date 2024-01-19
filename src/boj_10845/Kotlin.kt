package boj_10845

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val result = buildString {
        val queue = LinkedList<String>()
        repeat(readln().toInt()) {
            val st = StringTokenizer(readln())
            val cmd = st.nextToken()
            when {
                cmd[1] == 'u' -> queue.offer(st.nextToken())
                cmd[0] == 's' -> appendLine(queue.size)
                cmd[0] == 'e' -> appendLine(queue.isEmptyToInt())
                cmd[0] == 'f' -> appendLine(queue.frontOrMinus1())
                cmd[0] == 'b' -> appendLine(queue.backOrMinus1())
                else -> appendLine(queue.popOrMinus1())
            }
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}

fun LinkedList<String>.popOrMinus1(): String = if (isNotEmpty()) poll() else "-1"

fun LinkedList<String>.isEmptyToInt(): Int = if (isEmpty()) 1 else 0

fun LinkedList<String>.frontOrMinus1(): String = if (isNotEmpty()) peek() else "-1"

fun LinkedList<String>.backOrMinus1(): String = if (isNotEmpty()) peekLast() else "-1"
