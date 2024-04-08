package boj_18116

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private lateinit var parentOf: IntArray
private lateinit var countOf: IntArray

fun main() {
    parentOf = IntArray(size = 1_000_001) { it }
    countOf = IntArray(size = 1_000_001) { 1 }

    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        if (st.nextToken().first() == 'I') {
            union(st.nextToken().toInt(), st.nextToken().toInt())
        } else {
            sb.appendLine(countOf[find(st.nextToken().toInt())])
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
        countOf[parentOfA] += countOf[parentOfB]
    } else {
        parentOf[parentOfA] = parentOfB
        countOf[parentOfB] += countOf[parentOfA]
    }
}

private fun find(a: Int): Int =
    if (parentOf[a] == a) a else find(parentOf[a]).also { parentOf[a] = it }
