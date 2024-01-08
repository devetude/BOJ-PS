package boj_9711

import java.io.BufferedWriter
import java.util.StringTokenizer

fun main() {
    System.out.bufferedWriter().use { bw ->
        repeat(readln().toInt()) { i ->
            val case = i + 1
            val st = StringTokenizer(readln())
            val p = st.nextToken().toInt()
            val q = st.nextToken().toInt()

            val arr = LongArray(size = 3) { it.toLong() }
            if (p < 2) return@repeat bw.write(case, result = arr[p] % q)

            repeat(times = p - 2 + 1) {
                arr[2] = (arr[0] + arr[1]) % q
                arr[0] = arr[1]
                arr[1] = arr[2]
            }
            bw.write(case, arr[2])
        }

        bw.flush()
    }
}

fun BufferedWriter.write(case: Int, result: Long) {
    write("Case #")
    write(case.toString())
    write(": ")
    write(result.toString())
    write("\n")
}
