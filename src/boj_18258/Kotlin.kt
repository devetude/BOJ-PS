package boj_18258

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val queue = Queue(n)
    val result = buildString {
        repeat(n) {
            val st = StringTokenizer(readln())
            when (st.nextToken()) {
                "push" -> queue.push(st.nextToken().toInt())
                "pop" -> appendLine(queue.pop())
                "size" -> appendLine(queue.size())
                "empty" -> appendLine(if (queue.isEmpty()) 1 else 0)
                "front" -> appendLine(queue.front())
                else -> appendLine(queue.back())
            }
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}

class Queue(initSize: Int) {
    private val items: IntArray = IntArray(initSize)
    private var front: Int = 0
    private var back: Int = 0

    fun push(x: Int) {
        items[back++] = x
    }

    fun pop(): Int = if (isEmpty()) -1 else items[front++]

    fun size(): Int = back - front

    fun isEmpty(): Boolean = size() == 0

    fun front(): Int = if (isEmpty()) -1 else items[front]

    fun back(): Int = if (isEmpty()) -1 else items[back - 1]
}
