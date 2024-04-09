package boj_7511

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private lateinit var parentOf: IntArray

fun main() {
    val sb = StringBuilder()
    for (t in 1..readln().toInt()) {
        sb.append("Scenario ", t, ":", "\n")

        parentOf = IntArray(size = readln().toInt() + 1) { it }
        repeat(readln().toInt()) {
            val st = StringTokenizer(readln())
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()
            union(a, b)
        }

        repeat(readln().toInt()) {
            val st = StringTokenizer(readln())
            val u = st.nextToken().toInt()
            val v = st.nextToken().toInt()
            sb.appendLine(if (find(u) == find(v)) 1 else 0)
        }

        sb.appendLine()
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
