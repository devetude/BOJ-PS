package boj_20162

import kotlin.math.max

fun main() {
    val n = readln().toInt()

    val values = IntArray(n)
    val maxValueSums = IntArray(n)
    var maxValueSum = 0
    repeat(n) {
        values[it] = readln().toInt()
        maxValueSums[it] = values[it]
        for (i in 0..<it) {
            if (values[i] < values[it]) {
                maxValueSums[it] = max(maxValueSums[it], b = maxValueSums[i] + values[it])
            }
        }
        maxValueSum = max(maxValueSum, maxValueSums[it])
    }

    print(maxValueSum)
}
