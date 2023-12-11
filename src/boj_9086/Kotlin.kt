package boj_9086

fun main() {
    val result = buildString {
        repeat(readln().toInt()) {
            val s = readln()
            append(s.first(), s.last())
            appendLine()
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
