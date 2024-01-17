package boj_2441

fun main() {
    val n = readln().toInt()

    System.out.bufferedWriter().use { bw ->
        repeat(n) { row ->
            repeat(row) { bw.write(" ") }
            repeat(times = n - row) { bw.write("*") }
            bw.write("\n")
        }
        bw.flush()
    }
}
