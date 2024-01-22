package boj_5648

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val list = LinkedList<Long>()
    var line = readlnOrNull()
    while (line != null) {
        val st = StringTokenizer(line)
        while (st.hasMoreTokens()) list.add(st.nextToken().reversed().toLong())
        line = readlnOrNull()
    }
    list.removeFirst()
    list.sort()

    System.out.bufferedWriter().use {
        it.write(list.joinToString(separator = "\n"))
        it.flush()
    }
}
