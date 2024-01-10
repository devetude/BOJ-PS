package boj_1793

import java.math.BigInteger

fun main() {
    val counts = Array(size = 251) { BigInteger.ONE }
    for (i in 2..250) {
        counts[i] = counts[i - 1] + (counts[i - 2] shl 1)
    }

    System.out.bufferedWriter().use {
        while (true) {
            val n = readlnOrNull()?.toInt() ?: break

            it.write(counts[n].toString())
            it.write("\n")
        }

        it.flush()
    }
}
