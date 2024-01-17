package boj_2445

fun main() {
    val n = readln().toInt()

    System.out.bufferedWriter().use { bw ->
        for (i in 1 until n) {
            repeat(i) { bw.write("*") }
            repeat(times = n - i shl 1) { bw.write(" ") }
            repeat(i) { bw.write("*") }
            bw.write("\n")
        }
        repeat(times = n shl 1) { bw.write("*") }
        bw.write("\n")
        for (i in n - 1 downTo 1) {
            repeat(i) { bw.write("*") }
            repeat(times = n - i shl 1) { bw.write(" ") }
            repeat(i) { bw.write("*") }
            bw.write("\n")
        }
        bw.flush()
    }
}
