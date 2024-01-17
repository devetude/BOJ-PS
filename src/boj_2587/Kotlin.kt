package boj_2587

fun main() {
    val nums = ByteArray(size = 5)
    repeat(times = 5) { nums[it] = readln().toByte() }
    nums.sort()

    print("${nums.average().toInt()}\n${nums[2]}")
}
