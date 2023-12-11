package boj_18870

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val st = StringTokenizer(readln())
    val xs = IntArray(n)
    val set = HashSet<Int>()
    repeat(n) {
        val x = st.nextToken().toInt()
        xs[it] = x
        set.add(x)
    }

    val map = set.sortedDescending()
        .mapIndexed { idx, x -> x to set.size - idx - 1 }
        .toMap()
    val result = buildString { xs.forEach { x -> append(map[x], " ") } }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
