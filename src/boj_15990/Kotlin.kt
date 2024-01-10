package boj_15990

fun main() {
    val memory = Array(size = 100_001) { LongArray(size = 4) }
    memory[1][1] = 1
    memory[2][2] = 1
    memory[3][1] = 1
    memory[3][2] = 1
    memory[3][3] = 1

    for (i in 4..100_000) {
        memory[i][1] = (memory[i - 1][2] + memory[i - 1][3]) % 1_000_000_009L
        memory[i][2] = (memory[i - 2][1] + memory[i - 2][3]) % 1_000_000_009L
        memory[i][3] = (memory[i - 3][1] + memory[i - 3][2]) % 1_000_000_009L
    }

    System.out.bufferedWriter().use { bw ->
        repeat(readln().toInt()) {
            val n = readln().toInt()

            bw.write((memory[n].sum() % 1_000_000_009L).toString())
            bw.write("\n")
        }

        bw.flush()
    }
}
