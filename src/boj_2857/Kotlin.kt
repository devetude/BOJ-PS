package boj_2857

fun main() {
    val pi = pi(pattern = "FBI")

    System.out.bufferedWriter().use {
        val result = buildString {
            for (num in 1..5) {
                val nickname = readln()
                val result = kmp(nickname, pattern = "FBI", pi)
                if (-1 < result) append(num, " ")
            }
        }.ifEmpty { "HE GOT AWAY!" }

        it.write(result)
        it.flush()
    }
}

fun pi(pattern: String): IntArray {
    val pi = IntArray(pattern.length)

    var j = 0
    for (i in 1 until pattern.length) {
        while (0 < j && pattern[i] != pattern[j]) j = pi[j - 1]
        if (pattern[i] == pattern[j]) pi[i] = ++j
    }

    return pi
}

fun kmp(str: String, pattern: String, pi: IntArray): Int {
    var j = 0
    for (i in str.indices) {
        while (0 < j && str[i] != pattern[j]) j = pi[j - 1]
        if (str[i] == pattern[j]) {
            if (j == pattern.lastIndex) return pi[j]
            ++j
        }
    }

    return -1
}
