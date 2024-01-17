package boj_10808

fun main() {
    val counts = IntArray(size = 26)
    readln().forEach { ++counts[it - 'a'] }

    print(counts.joinToString(separator = " "))
}
