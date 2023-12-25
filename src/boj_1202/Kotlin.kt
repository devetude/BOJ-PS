package boj_1202

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val jewels = ArrayList<Jewel>(n)
    repeat(n) {
        st = StringTokenizer(readln())
        val m = st.nextToken().toInt()
        val v = st.nextToken().toInt()
        jewels.add(Jewel(m, v))
    }
    val capacities = IntArray(k)
    repeat(k) {
        val c = readln().toInt()
        capacities[it] = c
    }

    jewels.sortBy { it.m }
    capacities.sort()
    val pq = PriorityQueue<Int>(compareByDescending { it })
    var maxValue = 0L
    var idx = 0
    capacities.forEach { capacity ->
        while (idx < jewels.size) {
            val jewel = jewels[idx]
            if (capacity < jewel.m) break

            pq.offer(jewel.v)
            ++idx
        }

        if (pq.isNotEmpty()) maxValue += pq.poll()
    }

    println(maxValue)
}

data class Jewel(val m: Int = 0, val v: Int = 0)
