package boj_16916

fun main() {
    val s = readln()
    val p = readln()

    val result = if (-1 < s.indexOf(p)) 1 else 0
    println(result)
}
