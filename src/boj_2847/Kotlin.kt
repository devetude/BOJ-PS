package boj_2847

fun main() {
    val n = readln().toInt()
    val scores = IntArray(n)
    repeat(n) { scores[it] = readln().toInt() }

    var maxScore = scores.last()
    var downCount = 0
    for (i in scores.lastIndex - 1 downTo 0) {
        val score = scores[i]
        if (maxScore <= score) {
            downCount += score - --maxScore
        } else {
            maxScore = score
        }
    }

    println(downCount)
}
