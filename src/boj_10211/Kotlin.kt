package boj_10211

import java.util.StringTokenizer
import kotlin.math.max

fun main() {
    val t = readln().toInt()

    System.out.bufferedWriter().use { bw ->
        repeat(t) {
            val n = readln().toInt()
            val st = StringTokenizer(readln())

            val memory = IntArray(n)
            memory[0] = st.nextToken().toInt()
            var maxSum = memory[0]
            for (i in 1 until n) {
                val num = st.nextToken().toInt()
                memory[i] = max(num, b = memory[i - 1] + num)
                maxSum = max(maxSum, memory[i])
            }

            bw.write(maxSum.toString())
            bw.write("\n")
        }

        bw.flush()
    }
}
