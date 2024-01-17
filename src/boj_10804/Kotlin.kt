package boj_10804

fun main() {
    val cards = IntArray(size = 20) { it + 1 }
    repeat(times = 10) {
        var (i, j) = readln().split(" ").map { it.toInt() - 1 }
        while (i < j) {
            val tmp = cards[i]
            cards[i++] = cards[j]
            cards[j--] = tmp
        }
    }

    print(cards.joinToString(separator = " "))
}
