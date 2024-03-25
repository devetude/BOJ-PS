package boj_16172

fun main() {
    val s = readln()
    val k = readln()

    val plain = buildString { s.forEach { if (it !in '0'..'9') append(it) } }

    val failOf = IntArray(plain.length)
    var j = 0
    for (i in 1 until plain.length) {
        while (0 < j && plain[i] != plain[j]) j = failOf[j - 1]
        if (plain[i] == plain[j]) failOf[i] = ++j
    }

    j = 0
    for (i in plain.indices) {
        while (0 < j && plain[i] != k[j]) j = failOf[j - 1]
        if (plain[i] == k[j]) ++j
        if (j == k.length) return print(1)
    }

    print(0)
}
