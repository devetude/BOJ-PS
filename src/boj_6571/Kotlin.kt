package boj_6571

import java.math.BigInteger
import java.util.StringTokenizer

fun main() {
    System.out.bufferedWriter().use {
        while (true) {
            val st = StringTokenizer(readln())
            val a = st.nextToken().toBigInteger()
            val b = st.nextToken().toBigInteger()
            if (a == BigInteger.ZERO && b == BigInteger.ZERO) break

            val arr = Array(size = 3) { BigInteger.ZERO }
            arr[1] = BigInteger.ONE
            var count = 0
            for (i in 0..10_000) {
                arr[2] = arr[0] + arr[1]
                if (arr[2] in a..b) {
                    ++count
                    if (arr[2] == b) break
                }

                arr[0] = arr[1]
                arr[1] = arr[2]
            }

            it.write(count.toString())
            it.write("\n")
        }

        it.flush()
    }
}
