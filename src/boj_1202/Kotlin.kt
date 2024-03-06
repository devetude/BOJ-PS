package boj_1202

import java.util.PriorityQueue
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val jewels = Array(n) {
        st = StringTokenizer(readln())
        st.nextToken().toInt() to st.nextToken().toInt()
    }.apply { sortBy { it.first } }

    val capacities = IntArray(k) { readln().toInt() }.apply { sort() }

    val values = PriorityQueue<Int>(reverseOrder())
    var maxValue = 0L
    var i = 0
    capacities.forEach { capacity ->
        while (i < jewels.size) {
            val jewel = jewels[i]
            if (capacity < jewel.first) break

            values.offer(jewel.second)
            ++i
        }
        if (values.isNotEmpty()) maxValue += values.poll()
    }

    print(maxValue)
}
