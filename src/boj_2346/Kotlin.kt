package boj_2346

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val n: Int
    val values: List<String>
    BufferedReader(InputStreamReader(System.`in`)).use {
        n = it.readLine().toInt()
        values = it.readLine().split(" ")
    }

    val result = buildString {
        val dequeue = ArrayDeque<Balloon>(n).apply {
            values.forEachIndexed { i, s ->
                val balloon = Balloon(num = (i + 1).toShort(), s.toShort())
                addLast(balloon)
            }
        }

        var balloon = dequeue.removeFirst()
        append(balloon.num, " ")
        while (dequeue.isNotEmpty()) {
            if (0 < balloon.value) {
                repeat(times = balloon.value - 1) {
                    dequeue.addLast(dequeue.removeFirst())
                }
            } else {
                repeat(times = balloon.value * -1) {
                    dequeue.addFirst(dequeue.removeLast())
                }
            }
            balloon = dequeue.removeFirst()
            append(balloon.num, " ")
        }
    }

    BufferedWriter(OutputStreamWriter(System.`out`)).use {
        it.write(result)
        it.flush()
    }
}

data class Balloon(val num: Short, val value: Short)
