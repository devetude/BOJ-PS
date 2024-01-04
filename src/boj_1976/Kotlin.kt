package boj_1976

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val m = readln().toInt()

    val parents = IntArray(size = n + 1) { it }
    for (parent in 1..n) {
        val st = StringTokenizer(readln())
        for (child in 1..n) {
            if (st.nextToken().toInt() == 0) continue

            parents.union(parent, child)
        }
    }

    val st = StringTokenizer(readln())
    val firstParent = parents.find(st.nextToken().toInt())
    repeat(times = m - 1) {
        val parent = parents.find(st.nextToken().toInt())
        if (firstParent != parent) return println("NO")
    }

    println("YES")
}

fun IntArray.union(a: Int, b: Int) {
    val aParent = find(a)
    val bParent = find(b)
    if (aParent == bParent) return

    this[bParent] = aParent
}

fun IntArray.find(x: Int): Int {
    if (x == this[x]) return x

    this[x] = find(this[x])
    return this[x]
}
