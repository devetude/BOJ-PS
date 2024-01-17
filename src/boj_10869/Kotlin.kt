package boj_10869

import java.io.BufferedWriter
import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val a = st.nextToken().toInt()
    val b = st.nextToken().toInt()

    System.out.bufferedWriter().use {
        with(it) {
            writeLine(n = a + b)
            writeLine(n = a - b)
            writeLine(n = a * b)
            writeLine(n = a / b)
            writeLine(n = a % b)
        }
    }
}

fun BufferedWriter.writeLine(n: Int) {
    write(n.toString())
    write("\n")
}
