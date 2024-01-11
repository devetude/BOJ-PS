package boj_25099

fun main() {
    val n = readln().toInt()

    System.out.bufferedWriter().use { bw ->
        val set = HashSet<String>()
        repeat(n) {
            val word = readln()
            val key = String(word.toCharArray().apply { sort() })
            if (key !in set) {
                bw.write(word)
                bw.write("\n")
            }
            set.add(key)
        }

        bw.flush()
    }
}
