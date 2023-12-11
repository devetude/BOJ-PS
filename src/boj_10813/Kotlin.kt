package boj_10813

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val buckets = MutableList(size = n + 1) { it }
    repeat(m) {
        val (i, j) = readln().split(" ").map { it.toInt() }
        val temp = buckets[i]
        buckets[i] = buckets[j]
        buckets[j] = temp
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
