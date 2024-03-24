package boj_12026

import java.util.LinkedList

private const val B: Int = 0
private const val O: Int = 1
private const val J: Int = 2

fun main() {
    val n = readln().toInt()
    val s = readln()

    val minJumpOf = IntArray(n) { Int.MAX_VALUE }
    minJumpOf[0] = 0

    val indicesOf = Array(size = 3) { LinkedList<Int>() }
    indicesOf[B].add(0)

    for (i in 1 until s.length) {
        minJumpOf[i] = when (s[i]) {
            'B' -> {
                indicesOf[B].add(i)
                indicesOf[J].minOfOrNull { j ->
                    if (minJumpOf[j] == Int.MAX_VALUE) return@minOfOrNull Int.MAX_VALUE

                    val diff = i - j
                    minJumpOf[j] + diff * diff
                } ?: Int.MAX_VALUE
            }

            'O' -> {
                indicesOf[O].add(i)
                indicesOf[B].minOfOrNull { j ->
                    if (minJumpOf[j] == Int.MAX_VALUE) return@minOfOrNull Int.MAX_VALUE

                    val diff = i - j
                    minJumpOf[j] + diff * diff
                } ?: Int.MAX_VALUE
            }

            else -> {
                indicesOf[J].add(i)
                indicesOf[O].minOfOrNull { j ->
                    if (minJumpOf[j] == Int.MAX_VALUE) return@minOfOrNull Int.MAX_VALUE

                    val diff = i - j
                    minJumpOf[j] + diff * diff
                } ?: Int.MAX_VALUE
            }
        }
    }

    if (minJumpOf[s.lastIndex] == Int.MAX_VALUE) return print(-1)

    print(minJumpOf[s.lastIndex])
}
