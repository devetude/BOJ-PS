package boj_1003

fun main() {
    System.out.bufferedWriter().use { bw ->
        repeat(readln().toInt()) {
            val n = readln().toInt()

            val counts = Array(size = 41) { Count(zero = 0, one = 0) }
            counts[0] = Count(zero = 1, one = 0)
            counts[1] = Count(zero = 0, one = 1)

            for (i in 2..n) {
                counts[i] = counts[i - 2] + counts[i - 1]
            }

            bw.write(counts[n].toString())
            bw.write("\n")
        }

        bw.flush()
    }
}

data class Count(val zero: Int, val one: Int) {
    operator fun plus(other: Count): Count = Count(zero = zero + other.zero, one = one + other.one)

    override fun toString(): String = "$zero $one"
}
