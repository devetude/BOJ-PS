package boj_2164

import java.util.LinkedList

fun main() {
    val n = readln().toInt()

    val queue = LinkedList<Int>()
    repeat(n) { queue.offer(it + 1) }

    while (1 < queue.size) {
        queue.poll()
        queue.offerLast(queue.poll())
    }

    print(queue.peek())
}
