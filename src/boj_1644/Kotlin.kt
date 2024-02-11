package boj_1644

fun main() {
    val n = readln().toInt()
    if (n < 2) return print(0)

    val isPrime = BooleanArray(size = n + 1) { true }
    isPrime[0] = false
    isPrime[1] = false
    for (num in 2..n) {
        if (!isPrime[num]) continue

        for (multiple in (num shl 1)..n step num) {
            isPrime[multiple] = false
        }
    }

    var left = 2
    var right = 2
    var sum = 0
    var count = 0
    while (left <= n) {
        while (sum < n && right <= n) {
            if (isPrime[right]) sum += right
            ++right
        }

        if (sum == n) ++count

        sum -= left++
        while (left <= n && !isPrime[left]) ++left
    }

    print(count)
}
