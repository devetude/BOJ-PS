package boj_24511

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val aSt = StringTokenizer(readln())
    val bSt = StringTokenizer(readln())
    val dequeue = ArrayDeque<String>(n)
    repeat(n) {
        val a = aSt.nextToken()
        val b = bSt.nextToken()
        if (a == "0") dequeue.addFirst(b)
    }
    val m = readln().toInt()
    val cSt = StringTokenizer(readln())
    repeat(times = m - dequeue.size) {
        val c = cSt.nextToken()
        dequeue.addLast(c)
    }
    val result = dequeue.joinToString(separator = " ", limit = m, truncated = "")

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
