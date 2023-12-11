package boj_10811

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val buckets = MutableList(size = n + 1) { it }
    repeat(m) {
        var (i, j) = readln().split(" ").map { it.toInt() }
        while (i < j) {
            val temp = buckets[i]
            buckets[i] = buckets[j]
            buckets[j] = temp
            ++i
            --j
        }
    }
    val result = buildString {
        for (idx in 1 until buckets.size - 1) {
            append(buckets[idx], " ")
        }
        append(buckets.last())
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
