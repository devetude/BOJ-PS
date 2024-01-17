package boj_11328

import java.util.StringTokenizer

fun main() {
    System.out.bufferedWriter().use { bw ->
        repeat(readln().toInt()) {
            val st = StringTokenizer(readln())
            val a = st.nextToken()
            val b = st.nextToken()
            if (a.length != b.length) {
                bw.write("Impossible")
                return@repeat bw.write("\n")
            }

            val counts = IntArray(size = 26)
            for (i in a.indices) {
                ++counts[a[i] - 'a']
                --counts[b[i] - 'a']
            }

            val result = if (counts.any { it != 0 }) "Impossible" else "Possible"
            bw.write(result)
            bw.write("\n")
        }
        bw.flush()
    }
}
