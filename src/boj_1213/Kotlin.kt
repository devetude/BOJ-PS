package boj_1213

fun main() {
    val name = readln()

    val alphabetCounts = IntArray(size = 26)
    name.forEach { char -> ++alphabetCounts[char - 'A'] }

    val palindromeChars = CharArray(name.length)
    var palindromeI = 0
    var remainChar = ' '
    alphabetCounts.forEachIndexed { i, alphabetCount ->
        if (alphabetCount == 0) return@forEachIndexed

        val times = alphabetCount / 2
        alphabetCounts[i] -= 2 * times
        val char = (i + 'A'.code).toChar()
        if (alphabetCounts[i] == 1) remainChar = char

        repeat(times) {
            palindromeChars[palindromeI] = char
            palindromeChars[name.lastIndex - palindromeI] = char
            ++palindromeI
        }
    }

    val result = when (alphabetCounts.sum()) {
        0 -> palindromeChars.joinToString(separator = "")

        1 -> {
            palindromeChars[name.length / 2] = remainChar
            palindromeChars.joinToString(separator = "")
        }

        else -> "I'm Sorry Hansoo"
    }

    println(result)
}
