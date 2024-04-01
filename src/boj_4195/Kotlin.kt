package boj_4195

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.StringTokenizer

private lateinit var parentOf: HashMap<String, String>
private lateinit var sizeOf: HashMap<String, Int>

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        parentOf = hashMapOf()
        sizeOf = hashMapOf()

        repeat(readln().toInt()) {
            val st = StringTokenizer(readln())

            val a = st.nextToken()
            if (parentOf[a] == null) {
                parentOf[a] = a
                sizeOf[a] = 1
            }

            val b = st.nextToken()
            if (parentOf[b] == null) {
                parentOf[b] = b
                sizeOf[b] = 1
            }

            union(a, b)
            sb.appendLine(sizeOf[find(a)])
        }
    }

    BufferedWriter(OutputStreamWriter(System.out)).use {
        it.write(sb.toString())
        it.flush()
    }
}

private fun union(a: String, b: String) {
    val parentOfA = find(a)
    val parentOfB = find(b)
    if (parentOfA == parentOfB) return

    if (parentOfA < parentOfB) {
        parentOf[parentOfB] = parentOfA
        sizeOf[parentOfA] = sizeOf[parentOfA]!! + sizeOf[parentOfB]!!
    } else {
        parentOf[parentOfA] = parentOfB
        sizeOf[parentOfB] = sizeOf[parentOfA]!! + sizeOf[parentOfB]!!
    }
}

private fun find(a: String): String =
    if (parentOf[a] == a) a else find(parentOf[a]!!).also { parentOf[a] = it }
