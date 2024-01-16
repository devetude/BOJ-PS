package boj_2417

fun main() = print(approximateSqrtOf(readln().toLong()))

fun approximateSqrtOf(n: Long): Long {
    if (n < 1) return 0L

    var start = 1L
    var end = n
    var mid = start + end shr 1

    while (start <= end) {
        when {
            n / mid < mid -> end = mid - 1L
            mid * mid == n -> return mid
            else -> start = mid + 1L
        }
        mid = start + end shr 1
    }

    return end + 1L
}
