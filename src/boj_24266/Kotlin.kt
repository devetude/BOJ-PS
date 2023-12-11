package boj_24266

fun main() {
    val result = buildString {
        val n = readln().toLong()
        appendLine(value = n * n * n)
        append(3)
    }

    println(result)
}
