package boj_16437

import java.util.LinkedList
import java.util.StringTokenizer

lateinit var childrenOf: Array<LinkedList<Triple<Int, Long, String>>>

fun main() {
    val n = readln().toInt()

    childrenOf = Array(size = n + 1) { LinkedList() }
    repeat(times = n - 1) {
        val i = it + 2
        val st = StringTokenizer(readln())
        val t = st.nextToken()
        val a = st.nextToken().toLong()
        val p = st.nextToken().toInt()
        childrenOf[p].add(Triple(i, a, t))
    }

    val root = Triple(first = 1, second = 0L, third = "S")
    val aliveSheepCount = postorder(root)

    print(aliveSheepCount)
}

fun postorder(node: Triple<Int, Long, String>): Long {
    val (parent, count, type) = node
    val childSheepCount = childrenOf[parent].sumOf(::postorder)
    if (type == "S") return childSheepCount + count

    return if (childSheepCount < count) 0L else childSheepCount - count
}
