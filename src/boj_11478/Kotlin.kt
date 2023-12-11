package boj_11478

fun main() {
    val s = readln()

    val length = s.length
    val set = HashSet<String>()
    var window = 1
    while (window <= length) {
        for (startIdx in s.indices) {
            val endIdx = startIdx + window
            if (length < endIdx) continue

            set.add(s.substring(startIdx, endIdx))
        }
        ++window
    }

    println(set.size)
}
