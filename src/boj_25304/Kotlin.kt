package boj_25304

fun main() {
    var sum = readln().toInt()

    repeat(readln().toInt()) {
        val (price, quantity) = readln().split(" ").map { it.toInt() }
        sum -= price * quantity
    }

    println(if (sum == 0) "Yes" else "No")
}
