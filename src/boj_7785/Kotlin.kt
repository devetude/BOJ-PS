package boj_7785

import java.util.StringTokenizer

fun main() {
    val set = HashSet<String>()
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val name = st.nextToken()
        if (st.nextToken()[0] == 'e') set.add(name) else set.remove(name)
    }

    System.out.bufferedWriter().use {
        it.write(set.sortedDescending().joinToString(separator = "\n"))
        it.flush()
    }
}
