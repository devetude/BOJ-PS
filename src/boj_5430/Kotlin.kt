package boj_5430

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val result = buildString {
        repeat(readln().toInt()) {
            val p = readln()
            val n = readln().toInt()
            val x = readln()
            val st = StringTokenizer(x.substring(startIndex = 1, x.lastIndex), ",")

            val deque = LinkedList<String>()
            repeat(n) { deque.offer(st.nextToken()) }

            var isReversed = false
            p.forEach {
                if (it == 'R') {
                    isReversed = !isReversed
                    return@forEach
                }

                val isError = (if (isReversed) deque.pollLast() else deque.poll()) == null
                if (isError) {
                    appendLine(value = "error")
                    return@repeat
                }
            }

            if (isReversed) deque.reverse()
            appendLine(deque.joinToString(separator = ",", prefix = "[", postfix = "]"))
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
