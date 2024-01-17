package boj_9498

fun main() {
    val score = readln().toByte()

    val grade = when {
        score < 60 -> 'F'
        score < 70 -> 'D'
        score < 80 -> 'C'
        score < 90 -> 'B'
        else -> 'A'
    }
    print(grade)
}
