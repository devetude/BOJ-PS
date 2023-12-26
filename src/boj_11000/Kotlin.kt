package boj_11000

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val schedules = ArrayList<Schedule>()
    repeat(n) {
        val st = StringTokenizer(readln())
        val s = st.nextToken().toInt()
        val t = st.nextToken().toInt()
        schedules.add(Schedule(s, t))
    }

    schedules.sort()
    val pq = PriorityQueue<Int>()
    pq.offer(schedules.first().t)
    for (i in 1 until n) {
        val schedule = schedules[i]
        if (pq.peek() <= schedule.s) pq.poll()

        pq.offer(schedule.t)
    }

    println(pq.size)
}

data class Schedule(val s: Int, val t: Int) : Comparable<Schedule> {
    override fun compareTo(other: Schedule): Int =
        compareValuesBy(a = this, other, { it.s }, { it.t })
}
