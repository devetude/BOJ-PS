package boj_28278

import java.util.StringTokenizer

fun main() {
    val stack = Stack()
    val result = buildString {
        repeat(readln().toInt()) {
            val st = StringTokenizer(readln())
            when (st.nextToken().toInt()) {
                1 -> stack.push(st.nextToken().toInt())
                2 -> appendLine(stack.pop())
                3 -> appendLine(stack.size())
                4 -> appendLine(if (stack.isEmpty()) 1 else 0)
                else -> appendLine(stack.peek())
            }
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}

class Stack {
    private val items: IntArray = IntArray(size = 1_000_000)
    private var top: Int = -1

    fun push(x: Int) {
        items[++top] = x
    }

    fun pop(): Int = if (-1 < top) items[top--] else -1

    fun size(): Int = top + 1

    fun isEmpty(): Boolean = top == -1

    fun peek(): Int = if (-1 < top) items[top] else -1
}
