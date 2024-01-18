package boj_1158

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val list = LinkedList<Int>()
    repeat(n) { list.add(it + 1) }

    val result = IntArray(n)
    var i = 0
    var j = 0
    while (list.isNotEmpty()) {
        i = (i + k - 1) % list.size
        result[j++] = list.removeAt(i)
    }

    System.out.bufferedWriter().use {
        it.write(result.joinToString(separator = ", ", prefix = "<", postfix = ">"))
        it.flush()
    }
}
