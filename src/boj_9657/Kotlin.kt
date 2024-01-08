package boj_9657

fun main() {
    val n = readln().toInt()

    val isSkWinnable = BooleanArray(size = 1_001)
    isSkWinnable[1] = true
    isSkWinnable[3] = true
    isSkWinnable[4] = true
    for (i in 5..n) {
        isSkWinnable[i] = !isSkWinnable[i - 1] || !isSkWinnable[i - 3] || !isSkWinnable[i - 4]
    }

    print(if (isSkWinnable[n]) "SK" else "CY")
}
