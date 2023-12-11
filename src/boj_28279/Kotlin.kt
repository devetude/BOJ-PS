package boj_28279

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val dequeue = Dequeue(n)
    val result = buildString {
        repeat(n) {
            val st = StringTokenizer(readln())
            when (st.nextToken().toInt()) {
                1 -> dequeue.addFirst(st.nextToken().toInt())
                2 -> dequeue.addLast(st.nextToken().toInt())
                3 -> appendLine(dequeue.removeFirst())
                4 -> appendLine(dequeue.removeLast())
                5 -> appendLine(dequeue.size())
                6 -> appendLine(if (dequeue.isEmpty()) 1 else 0)
                7 -> appendLine(dequeue.first())
                else -> appendLine(dequeue.last())
            }
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}

class Dequeue(initSize: Int) {
    private val items: IntArray = IntArray(size = initSize shl 1)
    private var first: Int = initSize
    private var last: Int = first

    override fun toString(): String = items.joinToString(", ", prefix = "[", postfix = "]")

    fun addFirst(x: Int) {
        items[first--] = x
    }

    fun addLast(x: Int) {
        items[++last] = x
    }

    fun removeFirst(): Int = if (isEmpty()) -1 else items[++first]

    fun removeLast(): Int = if (isEmpty()) -1 else items[last--]

    fun size(): Int = last - first

    fun isEmpty(): Boolean = size() == 0

    fun first(): Int = if (isEmpty()) -1 else items[first + 1]

    fun last(): Int = if (isEmpty()) -1 else items[last]
}
