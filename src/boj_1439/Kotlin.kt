package boj_1439

import kotlin.math.min

fun main() {
    val s = readln()
    if (s.isEmpty()) return println(0)

    var previousChar = s[0]
    var zeroGroupCount = if (previousChar == '0') 1 else 0
    var oneGroupCount = if (previousChar == '1') 1 else 0
    for (i in 1..s.lastIndex) {
        val char = s[i]
        if (char == previousChar) continue

        if (previousChar == '0') ++oneGroupCount else ++zeroGroupCount
        previousChar = char
    }

    println(min(zeroGroupCount, oneGroupCount))
}
