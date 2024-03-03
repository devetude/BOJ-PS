package boj_20365

fun main() {
    readln()
    var prev = ' '
    var r = 0
    var b = 0
    readln().forEach {
        if (it != prev) if (it == 'R') ++r else ++b
        prev = it
    }

    val minCount = maxOf(r, b).coerceAtMost(maximumValue = 1) + minOf(r, b)
    print(minCount)
}
