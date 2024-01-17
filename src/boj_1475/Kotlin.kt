package boj_1475

fun main() {
    val counts = IntArray(size = 10)
    readln().forEach { ++counts[it - '0'] }
    val minSetExceptFor6N9 = counts.filterIndexed { num, _ -> num != 6 && num != 9 }.max()
    val minSetFor6N9 = counts[6] + counts[9] + 1 shr 1

    print(minSetFor6N9.coerceAtLeast(minSetExceptFor6N9))
}
