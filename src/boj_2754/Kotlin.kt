package boj_2754

fun main() {
    val grade = readln()
    if (grade == "F") return print("0.0")

    val score = 4.0 - (grade[0] - 'A') + when (grade[1]) {
        '+' -> 0.3
        '0' -> 0.0
        else -> -0.3
    }
    print(score)
}
