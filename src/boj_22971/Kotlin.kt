package boj_22971

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val st = StringTokenizer(readln())
    val nums = IntArray(n)
    val counts = IntArray(n) { 1 }
    System.out.bufferedWriter().use { bw ->
        repeat(n) {
            nums[it] = st.nextToken().toInt()
            for (i in 0..<it) {
                if (nums[i] < nums[it]) {
                    counts[it] += counts[i]
                    counts[it] %= 998_244_353
                }
            }

            bw.write(counts[it].toString())
            bw.write(" ")
        }

        bw.flush()
    }
}
