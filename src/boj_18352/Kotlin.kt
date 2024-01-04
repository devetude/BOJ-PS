package boj_18352

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()
    val k = st.nextToken().toInt()
    val x = st.nextToken().toInt()

    val adjacencyCities = Array(size = n + 1) { LinkedList<Int>() }
    repeat(m) {
        st = StringTokenizer(readln())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()
        adjacencyCities[a].add(b)
    }

    val nextCities = LinkedList<Int>()
    nextCities.offer(x)
    val distances = IntArray(size = n + 1) { Int.MAX_VALUE }
    distances[x] = 0
    while (nextCities.isNotEmpty()) {
        val currentCity = nextCities.poll()

        adjacencyCities[currentCity].forEach { nextCity ->
            val nextDistance = distances[currentCity] + 1
            if (nextDistance < distances[nextCity]) {
                distances[nextCity] = nextDistance
                nextCities.offer(nextCity)
            }
        }
    }
    val result = buildString {
        for (city in 1..n) {
            if (distances[city] == k) appendLine(city)
        }
    }.ifEmpty { "-1" }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
