package boj_1759

import java.util.StringTokenizer

val VOWELS: Set<Char> = setOf('a', 'e', 'i', 'o', 'u')

lateinit var chars: CharArray

val resultBuilder: StringBuilder = StringBuilder()

fun main() {
    var st = StringTokenizer(readln())
    val l = st.nextToken().toInt()
    val c = st.nextToken().toInt()

    st = StringTokenizer(readln())
    chars = CharArray(c) { st.nextToken()[0] }.apply { sort() }

    buildPassword(l)

    System.out.bufferedWriter().use {
        it.write(resultBuilder.toString())
        it.flush()
    }
}

fun buildPassword(
    l: Int,
    i: Int = 0,
    vowel: Int = 0,
    consonant: Int = 0,
    passwordBuilder: StringBuilder = StringBuilder()
) {
    if (l == 0) {
        if (vowel < 1 || consonant < 2) return

        resultBuilder.appendLine(passwordBuilder)
        return
    }

    for (j in i until chars.size) {
        var newVowel = vowel
        var newConsonant = consonant
        if (chars[j].isVowel()) ++newVowel else ++newConsonant
        val newPasswordBuilder = StringBuilder(passwordBuilder).append(chars[j])
        buildPassword(l = l - 1, i = j + 1, newVowel, newConsonant, newPasswordBuilder)
    }
}

fun Char.isVowel(): Boolean = this in VOWELS
