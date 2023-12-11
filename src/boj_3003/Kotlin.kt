package boj_3003

fun main() {
    val correctCounts = listOf(1, 1, 2, 2, 2, 8)

    val result = readln()
        .split(" ")
        .mapIndexed { i, s -> correctCounts[i] - s.toInt() }
        .joinToString(separator = " ")

    println(result)
}
