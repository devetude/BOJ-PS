package boj_15904

fun main() {
    val str = readln()

    var i = 0
    str.forEach { char ->
        if (char == "UCPC"[i]) {
            if (4 == ++i) return println("I love UCPC")
        }
    }

    println("I hate UCPC")
}
