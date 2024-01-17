package boj_2753

fun main() {
    val year = readln().toInt()
    val isLeapYear = if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) 1 else 0
    print(isLeapYear)
}
