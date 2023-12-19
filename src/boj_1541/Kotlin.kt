package boj_1541

fun main() {
    val expr = readln()

    var min = 0
    var sign = 1
    val sb = StringBuilder()
    expr.forEach {
        when (it) {
            '+', '-' -> min += sign * sb.toIntAndClear()
            else -> sb.append(it)
        }

        if (it == '-') sign = -1
    }
    min += sign * sb.toIntAndClear()

    println(min)
}

private fun StringBuilder.toIntAndClear(): Int = toString().toInt().also { clear() }
