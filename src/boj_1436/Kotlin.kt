package boj_1436

fun main() {
    val n = readln().toInt()

    var title = 666
    var count = 1
    while (count < n) {
        ++title
        if ("666" in title.toString()) ++count
    }

    println(title)
}
