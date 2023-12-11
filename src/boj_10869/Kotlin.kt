package boj_10869

fun main() {
    val (a, b) = readln().split(" ").map { it.toInt() }

    val result = buildString {
        appendLine(value = a + b)
        appendLine(value = a - b)
        appendLine(value = a * b)
        appendLine(value = a / b)
        appendLine(value = a % b)
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
