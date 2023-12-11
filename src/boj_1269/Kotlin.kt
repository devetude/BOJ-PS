package boj_1269

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val aSize = st.nextToken().toInt()
    val bSize = st.nextToken().toInt()

    st = StringTokenizer(readln())
    val aSet = HashSet<Int>()
    repeat(aSize) { aSet.add(st.nextToken().toInt()) }

    st = StringTokenizer(readln())
    val bSet = HashSet<Int>()
    repeat(bSize) { bSet.add(st.nextToken().toInt()) }

    val intersectSize = aSet.intersect(bSet).size

    println(aSet.size + bSet.size - 2 * intersectSize)
}
