package boj_15624

fun main() {
    val n = readln().toInt()

    val arr = IntArray(size = 3) { it }
    if (n < 2) return print(arr[n])

    for (i in 2..n) {
        arr[2] = (arr[0] + arr[1]) % 1_000_000_007
        arr[0] = arr[1]
        arr[1] = arr[2]
    }

    print(arr[2])
}
