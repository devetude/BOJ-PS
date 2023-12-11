package boj_2480

fun main() {
    val values = readln().split(" ").map { it.toInt() }.sorted()

    val result = when {
        values[0] == values[1] && values[1] == values[2] -> values[0] * 1_000 + 10_000
        values[0] == values[1] -> values[0] * 100 + 1_000
        values[1] == values[2] -> values[1] * 100 + 1_000
        else -> values[2] * 100
    }

    println(result)
}
