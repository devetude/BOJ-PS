package boj_2562

fun main() {
    var maxValue = readln().toByte()
    var maxValueNum = 1
    repeat(times = 8) {
        val value = readln().toByte()
        if (value < maxValue) return@repeat

        maxValue = value
        maxValueNum = it + 2
    }

    print("$maxValue\n$maxValueNum")
}
