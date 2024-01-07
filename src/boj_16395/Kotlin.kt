package boj_16395

import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    val nums = Array(size = n + 1) { IntArray(size = n + 1) }
    nums[1][1] = 1
    for (row in 1..n) {
        for (col in 1..row) {
            nums[row][col] = if (col == 1 || col == row) {
                1
            } else {
                nums[row - 1][col - 1] + nums[row - 1][col]
            }
        }
    }

    print(nums[n][k])
}
