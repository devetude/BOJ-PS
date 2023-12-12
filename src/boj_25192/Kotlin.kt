package boj_25192

fun main() {
    val n = readln().toInt()

    var count = 0
    val set = HashSet<String>()
    repeat(n) {
        val message = readln()
        if (message == "ENTER") {
            set.clear()
        } else {
            if (set.add(message)) ++count
        }
    }

    println(count)
}
