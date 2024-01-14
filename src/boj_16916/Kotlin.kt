package boj_16916

fun main() {
    val s = readln()
    val p = readln()

    val pi = pi(p)
    val result = if (-1 < kmp(s, p, pi)) 1 else 0

    print(result)
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
