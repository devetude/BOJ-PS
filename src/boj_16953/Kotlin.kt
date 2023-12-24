package boj_16953

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val a = st.nextToken().toLong()
    val b = st.nextToken().toLong()

    val queue = LinkedList<Next>()
    queue.offer(Next(a))
    while (queue.isNotEmpty()) {
        val current = queue.poll()
        if (current.x == b) return println(current.operateTimes)

        OPERATOR.entries
            .asSequence()
            .map { it.apply(current.x) }
            .filter { it <= b }
            .map { Next(it, operateTimes = current.operateTimes + 1) }
            .forEach(queue::offer)
    }

    println(-1)
}

data class Next(val x: Long, val operateTimes: Int = 1)

enum class OPERATOR {
    MULTIPLY_2 {
        override fun apply(x: Long): Long = x shl 1
    },
    APPEND_1 {
        override fun apply(x: Long): Long = x * 10 + 1
    };

    abstract fun apply(x: Long): Long
}
