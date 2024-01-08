package boj_8394

fun main() {
    val n = readln().toInt()

    val arr = IntArray(size = 3)
    arr[1] = 2
    arr[2] = 3

    if (n < 4) return print(arr[n - 1])

    for (i in 4..n) {
        arr[0] = arr[1]
        arr[1] = arr[2]
        arr[2] = (arr[1] + arr[0]) % 10
    }

    print(arr[2])
}
