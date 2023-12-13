package boj_25501

fun main() {
    val t = readln().toInt()

    val result = buildString {
        repeat(t) {
            val result = readln().isPalindrome()
            append(if (result.isPalindrome) 1 else 0, " ", result.times)
            appendLine()
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}

fun String.isPalindrome(left: Int = 0, right: Int = lastIndex, recursionTimes: Int = 1): Result =
    when {
        right <= left -> Result(isPalindrome = true, recursionTimes)
        this[left] != this[right] -> Result(isPalindrome = false, recursionTimes)
        else -> isPalindrome(
            left = left + 1,
            right = right - 1,
            recursionTimes = recursionTimes + 1
        )
    }

data class Result(val isPalindrome: Boolean, val times: Int)
