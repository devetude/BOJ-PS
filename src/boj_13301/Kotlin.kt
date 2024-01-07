package boj_13301

fun main() {
    val n = readln().toInt()

    val sides = LongArray(size = n + 1)
    sides[1] = 1
    for (i in 2..n) {
        sides[i] = sides[i - 2] + sides[i - 1]
    }
    val perimeter = (sides[n - 1] shl 1) + (sides[n] shl 2)

    print(perimeter)
}
