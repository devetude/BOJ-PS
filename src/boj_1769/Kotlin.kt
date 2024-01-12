package boj_1769

fun main() {
    var x = readln()

    var count = 0
    while (1 < x.length) {
        ++count
        val y = x.sumOf { it - '0' }
        x = y.toString()
    }
    val result = when (x) {
        "3", "6", "9" -> "YES"
        else -> "NO"
    }

    print("$count\n$result")
}
