package boj_2164

fun main() {
    val n = readln().toInt()

    val arr = IntArray(size = (n shl 1) - 1) { it + 1 }
    var first = 0
    var last = n - 1

    while (first < last) {
        ++first
        arr[++last] = arr[first++]
    }

    print(arr[first])
}
