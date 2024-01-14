package boj_15829

fun main() {
    val l = readln().toInt()
    val input = readln()

    var hash = 0L
    for (i in 0 until l) {
        val a = input[i] - 'a' + 1
        var r = 1L
        repeat(i) {
            r *= 31L
            r %= 1_234_567_891L
        }
        hash += a * r
        hash %= 1_234_567_891L
    }

    print(hash)
}
