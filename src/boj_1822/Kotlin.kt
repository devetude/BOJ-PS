package boj_1822

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val nA = st.nextToken().toInt()
    val nB = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val aArr = IntArray(nA) { st.nextToken().toInt() }.apply { sort() }

    st = StringTokenizer(readln())
    val bSet = HashSet<Int>()
    repeat(nB) { bSet.add(st.nextToken().toInt()) }

    var size = 0
    val sb = StringBuilder("\n")
    aArr.forEach {
        if (it !in bSet) {
            ++size
            sb.append(it, ' ')
        }
    }

    System.out.bufferedWriter().use {
        it.write(size.toString())
        it.write(sb.toString())
        it.flush()
    }
}
