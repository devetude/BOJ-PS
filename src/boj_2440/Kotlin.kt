package boj_2440

fun main() {
    val n = readln().toInt()

    System.out.bufferedWriter().use { bw ->
        repeat(n) { row ->
            repeat(times = n - row) { bw.write("*") }
            bw.write("\n")
        }
        bw.flush()
    }
}
