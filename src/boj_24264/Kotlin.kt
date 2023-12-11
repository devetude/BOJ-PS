package boj_24264

fun main() {
    val result = buildString {
        val n = readln().toLong()
        appendLine(value = n * n)
        append(2)
    }

    println(result)
}
