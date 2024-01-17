package boj_2446

fun main() {
    val n = readln().toInt()

    System.out.bufferedWriter().use { bw ->
        repeat(n) { row ->
            repeat(row) { bw.write(" ") }
            repeat(times = (n - row shl 1) - 1) { bw.write("*") }
            bw.write("\n")
        }
        for (i in 1 until n) {
            repeat(times = n - i - 1) { bw.write(" ") }
            repeat(times = (i shl 1) + 1) { bw.write("*") }
            bw.write("\n")
        }
        bw.flush()
    }
}
