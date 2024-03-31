package boj_1717

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private lateinit var parentOf: IntArray

fun main() {
    var st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    parentOf = IntArray(size = n + 1) { it }

    val sb = StringBuilder()
    repeat(m) {
        st = StringTokenizer(readln())
        val c = st.nextToken()
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        if (c == "0") {
            union(a, b)
        } else {
            sb.appendLine(if (find(a) == find(b)) "YES" else "NO")
        }
    }

    BufferedWriter(OutputStreamWriter(System.out)).use {
        it.write(sb.toString())
        it.flush()
    }
}

private fun union(a: Int, b: Int) {
    val parentOfA = find(a)
    val parentOfB = find(b)
    if (parentOfA == parentOfB) return

    if (parentOfA < parentOfB) {
        parentOf[parentOfB] = parentOfA
    } else {
        parentOf[parentOfA] = parentOfB
    }
}

private fun find(a: Int): Int =
    if (parentOf[a] == a) a else find(parentOf[a]).also { parentOf[a] = it }
