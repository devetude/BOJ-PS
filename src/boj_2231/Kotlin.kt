package boj_2231

fun main() {
    val n = readln().toInt()

    var num = 1
    while (num < n) {
        val decompositionSum = num + num.toString().sumOf(Character::getNumericValue)
        if (decompositionSum == n) return println(num)
        ++num
    }

    println(0)
}
