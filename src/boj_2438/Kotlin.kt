package boj_2438

fun main() = System.out.bufferedWriter().use { bw ->
    repeat(readln().toInt()) {
        repeat(times = it + 1) { bw.write("*") }
        bw.write("\n")
    }
    bw.flush()
}
