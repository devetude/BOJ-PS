package boj_11729

var count: Int = 0

fun main() {
    val n = readln().toInt()

    val moveBuilder = StringBuilder()
    move(n, moveBuilder, from = 1, to = 3, tmp = 2)

    System.out.bufferedWriter().use {
        it.write(count.toString())
        it.write("\n")
        it.write(moveBuilder.toString())
        it.flush()
    }
}

fun move(n: Int, moveBuilder: StringBuilder, from: Int, to: Int, tmp: Int) {
    if (n == 1) {
        ++count
        moveBuilder.append(from, ' ').appendLine(to)
        return
    }

    move(n = n - 1, moveBuilder, from, tmp, to)
    move(n = 1, moveBuilder, from, to, tmp)
    move(n = n - 1, moveBuilder, tmp, to, from)
}
