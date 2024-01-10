package boj_9658

fun main() {
    val n = readln().toInt()

    val isSkWinnable = BooleanArray(size = 1_001)
    isSkWinnable[2] = true
    isSkWinnable[4] = true

    for (i in 5..n) {
        if (!isSkWinnable[i - 1] || !isSkWinnable[i - 3] || !isSkWinnable[i - 4]) {
            isSkWinnable[i] = true
        }
    }

    print(if (isSkWinnable[n]) "SK" else "CY")
}
