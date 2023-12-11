package boj_3052

fun main() {
    val remains = mutableSetOf<Int>()
    repeat(times = 10) {
        remains.add(readln().toInt() % 42)
    }

    println(remains.size)
}
