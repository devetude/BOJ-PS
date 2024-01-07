package boj_9625

fun main() {
    val k = readln().toInt()

    val aCounts = IntArray(size = k + 1)
    val bCounts = IntArray(size = k + 1)
    bCounts[1] = 1

    for (i in 2..k) {
        aCounts[i] = bCounts[i - 1]
        bCounts[i] = bCounts[i - 2] + bCounts[i - 1]
    }

    print("${aCounts[k]} ${bCounts[k]}")
}
