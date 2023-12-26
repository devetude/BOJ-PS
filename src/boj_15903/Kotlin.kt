package boj_15903

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    st = StringTokenizer(readln())
    val pq = PriorityQueue<Long>()
    repeat(n) { pq.add(st.nextToken().toLong()) }

    repeat(m) {
        val minSum = pq.poll() + pq.poll()
        repeat(times = 2) { pq.offer(minSum) }
    }

    println(pq.sum())
}
