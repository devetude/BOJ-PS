package boj_10810

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val buckets = MutableList(size = n + 1) { 0 }
    repeat(m) {
        val (i, j, k) = readln().split(" ").map { it.toInt() }
        for (idx in i..j) {
            if (buckets[idx] != k) buckets[idx] = k
        }
    }
    val result = buildString {
        for (idx in 1 until buckets.size - 1) {
            append(buckets[idx])
            append(" ")
        }
        append(buckets.last())
    }

    println(result)
}
