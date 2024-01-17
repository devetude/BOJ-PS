package boj_10093

fun main() {
    val nums = readln().split(" ").map { it.toLong() }.sorted()

    System.out.bufferedWriter().use {
        val count = (nums[1] - nums[0] - 1L).coerceAtLeast(minimumValue = 0L)
        it.write(count.toString())
        if (count < 1L) return it.flush()

        it.write("\n")
        it.write((nums[0] + 1L until nums[1]).joinToString(separator = " "))
        it.flush()
    }
}
