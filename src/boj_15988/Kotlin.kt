package boj_15988

fun main() {
    System.out.bufferedWriter().use { bw ->
        repeat(readln().toInt()) {
            val n = readln().toInt()

            val memory = LongArray(size = 4)
            memory[0] = 1
            memory[1] = 2
            memory[2] = 4
            if (n < 4) {
                bw.write(memory[n - 1].toString())
                bw.write("\n")
                return@repeat
            }

            for (i in 4..n) {
                memory[3] = (memory[0] + memory[1] + memory[2]) % 1_000_000_009
                memory[0] = memory[1]
                memory[1] = memory[2]
                memory[2] = memory[3]
            }

            bw.write(memory[3].toString())
            bw.write("\n")
        }

        bw.flush()
    }
}
