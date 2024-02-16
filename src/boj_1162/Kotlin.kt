package boj_1162

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val adjacencyList = Array<LinkedList<Pair<Int, Int>>>(size = n + 1) { LinkedList() }
    repeat(m) {
        st = StringTokenizer(readln())
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        val time = st.nextToken().toInt()
        adjacencyList[from].add(to to time)
        adjacencyList[to].add(from to time)
    }

    val pq = PriorityQueue(compareBy<Triple<Int, Int, Long>> { it.third }.thenBy { it.first })
        .apply { offer(Triple(first = 0, second = 1, third = 0L)) }

    val minTimes = Array(size = k + 1) { LongArray(size = n + 1) { Long.MAX_VALUE } }
        .apply { this[0][1] = 0L }
    
    var minTime = Long.MAX_VALUE
    while (pq.isNotEmpty()) {
        val (count, current, time) = pq.poll()
        if (minTimes[count][current] < time) continue

        if (current == n) {
            if (time < minTime) minTime = time
            continue
        }

        adjacencyList[current].forEach { (next, time) ->
            if (count < k) {
                val nextTime = minTimes[count][current]
                if (nextTime < minTimes[count + 1][next]) {
                    minTimes[count + 1][next] = nextTime
                    pq.offer(Triple(first = count + 1, next, nextTime))
                }
            }

            val nextTime = minTimes[count][current] + time
            if (nextTime < minTimes[count][next]) {
                minTimes[count][next] = nextTime
                pq.offer(Triple(count, next, nextTime))
            }
        }
    }

    print(minTime)
}
