package boj_2295

fun main() {
    val n = readln().toInt()
    val u = IntArray(n) { readln().toInt() }.apply { sort() }

    val twoSums = mutableListOf<Int>()
    for (i in u.indices) {
        for (j in i until n) twoSums.add(u[i] + u[j])
    }
    twoSums.sort()

    for (i in n - 1 downTo 0) {
        for (j in 0 until i) {
            val diff = u[i] - u[j]
            if (-1 < twoSums.binarySearch(diff)) return print(u[i])
        }
    }
}
