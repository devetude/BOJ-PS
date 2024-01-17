package boj_2439

fun main() {
    val n = readln().toInt()

    System.out.bufferedWriter().use { bw ->
        repeat(n) { row ->
            repeat(times = n - row - 1) { bw.write(" ") }
            repeat(times = row + 1) { bw.write("*") }
            bw.write("\n")
        }
        bw.flush()
    }
}
