package boj_25314

fun main() {
    val n = readln().toInt()

    val times = n / 4
    val result = buildString {
        repeat(times) { append("long ") }
        appendLine(value = "int")
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
