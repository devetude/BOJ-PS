package boj_2444

fun main() {
    val n = readln().toInt()

    System.out.bufferedWriter().use { bw ->
        repeat(n) { row ->
            repeat(times = n - row - 1) { bw.write(" ") }
            repeat(times = (row shl 1) + 1) { bw.write("*") }
            bw.write("\n")
        }
        for (i in n - 1 downTo 1) {
            repeat(times = n - i) { bw.write(" ") }
            repeat(times = (i shl 1) - 1) { bw.write("*") }
            bw.write("\n")
        }
        bw.flush()
    }
}
