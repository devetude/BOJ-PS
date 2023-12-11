package boj_7785

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val names = HashSet<String>()
    repeat(n) {
        val st = StringTokenizer(readln())
        val name = st.nextToken()
        when (st.nextToken()) {
            "enter" -> names.add(name)
            else -> names.remove(name)
        }
    }

    val result = names.sortedDescending().joinToString(separator = "\n")

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
