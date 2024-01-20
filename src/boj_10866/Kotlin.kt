package boj_10866

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val result = buildString {
        val deque = LinkedList<String>()
        repeat(readln().toInt()) {
            val st = StringTokenizer(readln())
            val cmd = st.nextToken()
            when {
                cmd[1] == 'u' && cmd[5] == 'f' -> deque.offerFirst(st.nextToken())
                cmd[1] == 'u' && cmd[5] == 'b' -> deque.offer(st.nextToken())
                cmd[1] == 'o' && cmd[4] == 'f' -> appendLine(deque.popOrMinus1())
                cmd[1] == 'o' && cmd[4] == 'b' -> appendLine(deque.popBackOrMinus1())
                cmd[0] == 's' -> appendLine(deque.size)
                cmd[0] == 'e' -> appendLine(deque.isEmptyToInt())
                cmd[0] == 'f' -> appendLine(deque.frontOrMinus1())
                else -> appendLine(deque.backOrMinus1())
            }
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}

fun LinkedList<String>.popOrMinus1(): String = if (isNotEmpty()) poll() else "-1"

fun LinkedList<String>.popBackOrMinus1(): String = if (isNotEmpty()) pollLast() else "-1"

fun LinkedList<String>.isEmptyToInt(): Int = if (isEmpty()) 1 else 0

fun LinkedList<String>.frontOrMinus1(): String = if (isNotEmpty()) peek() else "-1"

fun LinkedList<String>.backOrMinus1(): String = if (isNotEmpty()) peekLast() else "-1"
