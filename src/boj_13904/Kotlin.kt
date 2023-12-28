package boj_13904

import java.util.PriorityQueue
import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val pq = PriorityQueue<Pair<Int, Int>> { a, b ->
        when {
            a.second > b.second -> -1
            a.second < b.second -> 1
            else -> b.first - a.first
        }
    }
    var maxDay = Int.MIN_VALUE
    repeat(n) {
        val st = StringTokenizer(readln())
        val d = st.nextToken().toInt()
        val w = st.nextToken().toInt()
        pq.offer(d to w)
        maxDay = max(maxDay, d)
    }

    val isVisited = BooleanArray(size = maxDay + 1)
    var maxPoint = 0
    while (pq.isNotEmpty()) {
        val (d, w) = pq.poll()
        if (!isVisited[d]) {
            maxPoint += w
            isVisited[d] = true
            continue
        }

        for (i in d - 1 downTo 1) {
            if (!isVisited[i]) {
                maxPoint += w
                isVisited[i] = true
                break
            }
        }
    }

    println(maxPoint)
}
