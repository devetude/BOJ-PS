package boj_2738

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val aMatrix = MutableList<List<Int>>(size = n) { emptyList() }
    repeat(n) { row -> aMatrix[row] = readln().split(" ").map { it.toInt() } }

    val bMatrix = MutableList<List<Int>>(size = n) { emptyList() }
    repeat(n) { row -> bMatrix[row] = readln().split(" ").map { it.toInt() } }

    val result = buildString {
        for (row in 0 until n) {
            for (col in 0 until m) {
                append(aMatrix[row][col] + bMatrix[row][col], " ")
            }
        }
        appendLine()
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
