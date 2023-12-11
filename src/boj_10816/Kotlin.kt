package boj_10816

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    var st = StringTokenizer(readln())
    val map = HashMap<Int, Int>()
    repeat(n) {
        val number = st.nextToken().toInt()
        val count = map.getOrDefault(number, 0)
        map[number] = count + 1
    }

    val m = readln().toInt()
    st = StringTokenizer(readln())
    val result = buildString {
        repeat(m) {
            val number = st.nextToken().toInt()
            append(map.getOrDefault(number, 0), " ")
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
