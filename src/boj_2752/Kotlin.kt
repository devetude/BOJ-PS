package boj_2752

fun main() = print(
    readln()
        .split(" ")
        .sortedBy { it.toInt() }
        .joinToString(separator = " ")
)
