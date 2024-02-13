package boj_2075

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val nums = IntArray(size = n * n)
    repeat(n) { row ->
        val st = StringTokenizer(readln())
        repeat(n) { col -> nums[n * row + col] = st.nextToken().toInt() }
    }
    nums.sortDescending()

    print(nums[n - 1])
}
