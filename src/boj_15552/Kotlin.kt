package boj_15552

fun main() = System.out.bufferedWriter().use { bw ->
    repeat(readln().toInt()) {
        bw.write(readln().split(" ").sumOf { it.toInt() }.toString())
        bw.write("\n")
    }
    bw.flush()
}
