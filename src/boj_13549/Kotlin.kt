package boj_13549

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val minDurations = IntArray(size = 100_001) { Int.MAX_VALUE }
    minDurations[n] = 0
    val pq = PriorityQueue<Point>()
    pq.offer(Point(n, duration = 0))
    while (pq.isNotEmpty()) {
        val point = pq.poll()
        val x = point.x

        Move.entries
            .asSequence()
            .map { move -> Point(move.from(x), duration = minDurations[x] + move.duration) }
            .filter { nextPoint ->
                nextPoint.x in (0..100_000) &&
                        nextPoint.duration < minDurations[nextPoint.x]
            }
            .forEach { nextPoint ->
                minDurations[nextPoint.x] = nextPoint.duration
                pq.offer(nextPoint)
            }
    }

    println(minDurations[k])
}

data class Point(val x: Int, val duration: Int) : Comparable<Point> {
    override fun compareTo(other: Point): Int = compareValuesBy(a = this, other) { it.duration }
}

enum class Move(val duration: Int = 1) {
    LEFT {
        override fun from(x: Int): Int = x - 1
    },
    RIGHT {
        override fun from(x: Int): Int = x + 1
    },
    TELEPORT(duration = 0) {
        override fun from(x: Int): Int = x * 2
    };

    abstract fun from(x: Int): Int
}
