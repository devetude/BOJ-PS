package boj_2744

fun main() {
    val gap = 'a' - 'A'
    val result = buildString {
        readln().asSequence()
            .map { if (it in 'A'..'Z') it + gap else it - gap }
            .forEach(::append)
    }

    print(result)
}
