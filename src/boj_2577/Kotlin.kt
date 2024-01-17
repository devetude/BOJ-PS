package boj_2577

fun main() {
    val a = readln().toInt()
    val b = readln().toInt()
    val c = readln().toInt()

    val count = IntArray(size = 10)
    (a * b * c).toString().forEach { ++count[it - '0'] }

    print(count.joinToString(separator = "\n"))
}
