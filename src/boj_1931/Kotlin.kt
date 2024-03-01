package boj_1931

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val schedules = Array(n) {
        val st = StringTokenizer(readln())
        st.nextToken().toInt() to st.nextToken().toInt()
    }.apply { sortWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first }) }

    var current = 0
    var size = 0
    schedules.forEach { (start, end) ->
        if (current <= start) {
            ++size
            current = end
        }
    }

    print(size)
}
