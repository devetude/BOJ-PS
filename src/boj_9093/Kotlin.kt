package boj_9093

fun main() {
    System.out.bufferedWriter().use { bw ->
        repeat(readln().toInt()) {
            val sb = StringBuilder()
            readln().forEach { c ->
                if (c == ' ') {
                    bw.write(sb.reverse().toString())
                    bw.write(" ")
                    sb.clear()
                } else {
                    sb.append(c)
                }
            }
            bw.write(sb.reverse().toString())
            bw.write("\n")
        }

        bw.flush()
    }
}
