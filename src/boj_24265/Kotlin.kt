package boj_24265

fun main() {
    val result = buildString {
        val n = readln().toLong()
        appendLine(value = n * (n - 1) shr 1)
        append(2)
    }

    println(result)
}
