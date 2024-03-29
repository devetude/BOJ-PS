package boj_1747

import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()

    val isPrime = BooleanArray(size = 1_003_002) { true }.apply {
        this[0] = false
        this[1] = false
    }

    for (num in 2..sqrt(isPrime.lastIndex.toDouble()).toInt()) {
        if (!isPrime[num]) continue
        for (j in num * num until isPrime.size step num) isPrime[j] = false
    }

    for (num in n until isPrime.size) {
        if (isPrime[num] && isPalindrome(num)) return print(num)
    }

    print(2)
}

private fun isPalindrome(num: Int): Boolean {
    val str = num.toString()
    var left = 0
    var right = str.lastIndex
    while (left < right) if (str[left++] != str[right--]) return false

    return true
}
