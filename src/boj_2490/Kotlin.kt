package boj_2490

fun main() = repeat(times = 3) {
    println('A' + (readln().count { it == '0' } + 4) % 5)
}
