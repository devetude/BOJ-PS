package boj_2588

fun main() {
    val a = readln().toInt()
    val bStr = readln()

    val result = buildString {
        var sum = 0
        var pow = 1
        repeat(times = 3) {
            val element = a * Character.getNumericValue(bStr[2 - it])
            appendLine(element)
            sum += element * pow
            pow *= 10
        }
        appendLine(sum)
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
