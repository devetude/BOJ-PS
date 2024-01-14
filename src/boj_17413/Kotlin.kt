package boj_17413

import java.util.LinkedList

fun main() {
    System.out.bufferedWriter().use {
        val dequeue = LinkedList<Char>()
        var isTagOpened = false
        for (c in readln()) {
            when (c) {
                ' ' -> {
                    dequeue.addLast(c)
                    if (!isTagOpened) {
                        it.write(dequeue.joinToString(separator = ""))
                        dequeue.clear()
                    }
                }

                '<' -> {
                    isTagOpened = true
                    dequeue.addLast(c)
                }

                '>' -> {
                    isTagOpened = false
                    dequeue.addLast(c)
                    it.write(dequeue.joinToString(separator = ""))
                    dequeue.clear()
                }

                else -> if (isTagOpened) dequeue.addLast(c) else dequeue.addFirst(c)
            }
        }

        it.write(dequeue.joinToString(separator = ""))
        it.flush()
    }
}
