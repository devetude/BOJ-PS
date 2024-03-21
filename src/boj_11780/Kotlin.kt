package boj_11780

import java.util.LinkedList
import java.util.StringTokenizer

private const val INF: Int = Int.MAX_VALUE shr 1

fun main() {
    val n = readln().toInt()

    val costBetween = Array(size = n + 1) { IntArray(size = n + 1) { INF } }
    val nextBetween = Array(size = n + 1) { IntArray(size = n + 1) }
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        costBetween[a][b] = minOf(costBetween[a][b], c)
        nextBetween[a][b] = b
    }
    for (a in 1..n) costBetween[a][a] = 0

    for (via in 1..n) {
        for (a in 1..n) {
            for (b in 1..n) {
                val viaCost = costBetween[a][via] + costBetween[via][b]
                if (viaCost < costBetween[a][b]) {
                    costBetween[a][b] = viaCost
                    nextBetween[a][b] = nextBetween[a][via]
                }
            }
        }
    }

    val sb = StringBuilder()
    for (a in 1..n) {
        for (b in 1..n) {
            val cost = if (costBetween[a][b] == INF) 0 else costBetween[a][b]
            sb.append(cost, ' ')
        }
        sb.appendLine()
    }

    for (a in 1..n) {
        for (b in 1..n) {
            if (costBetween[a][b] == 0 || costBetween[a][b] == INF) {
                sb.appendLine(value = 0)
                continue
            }

            val paths = LinkedList<Int>()
            var next = a
            while (next != b) {
                paths.addLast(next)
                next = nextBetween[next][b]
            }
            paths.addLast(next)
            sb.append(paths.size, ' ')
            sb.appendLine(paths.joinToString(separator = " "))
        }
    }

    System.out.bufferedWriter().use {
        it.write(sb.toString())
        it.flush()
    }
}
