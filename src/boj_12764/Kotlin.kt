package boj_12764

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val schedules = PriorityQueue<Pair<Int, Int>>(compareBy { it.first }).apply {
        repeat(n) {
            val st = StringTokenizer(readln())
            val p = st.nextToken().toInt()
            val q = st.nextToken().toInt()
            offer(p to q)
        }
    }

    val seats = PriorityQueue<Int>().apply { addAll(1..n) }
    val processingSchedules = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.second })
    var maxSeat = 1
    val usedCounts = IntArray(size = n + 1)
    while (schedules.isNotEmpty()) {
        val schedule = schedules.poll()

        while (processingSchedules.isNotEmpty() &&
            processingSchedules.peek().second < schedule.first
        ) {
            val seat = processingSchedules.poll().third
            seats.offer(seat)
        }

        val seat = seats.poll()
        if (maxSeat < seat) maxSeat = seat
        ++usedCounts[seat]
        processingSchedules.add(Triple(schedule.first, schedule.second, seat))
    }

    val result = buildString {
        appendLine(maxSeat)
        for (seat in 1..maxSeat) append(usedCounts[seat], ' ')
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
