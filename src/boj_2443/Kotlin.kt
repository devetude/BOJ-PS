package boj_2443

fun main() {
    val n = readln().toInt()

    System.out.bufferedWriter().use { bw ->
        repeat(n) { row ->
            repeat(row) { bw.write(" ") }
            repeat(times = (n - row shl 1) - 1) { bw.write("*") }
            bw.write("\n")
        }
        bw.flush()
    }
}
