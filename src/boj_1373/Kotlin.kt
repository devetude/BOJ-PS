package boj_1373

fun main() {
    val binaryStr = readln()

    val result = buildString {
        for (i in binaryStr.lastIndex downTo 0 step 3) {
            var sum = 0
            for (j in i downTo i - 2) {
                if (j < 0) break
                if (binaryStr[j] == '0') continue
                sum += (1 shl (i - j))
            }
            append(sum)
        }
    }.reversed()

    print(result)
}
