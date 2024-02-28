package boj_11004

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

lateinit var arr: IntArray
lateinit var tmp: IntArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    arr = IntArray(n) { st.nextToken().toInt() }
    tmp = IntArray(n)
    mergeSort()

    print(arr[k - 1])
}

fun mergeSort(start: Int = 0, end: Int = arr.size) {
    if (start == end - 1) return

    val mid = start + end shr 1
    mergeSort(start, mid)
    mergeSort(mid, end)
    sort(start, end)
}

fun sort(start: Int, end: Int) {
    val mid = start + end shr 1
    var left = start
    var right = mid
    for (i in start until end) {
        tmp[i] = when {
            left == mid -> arr[right++]
            right == end -> arr[left++]
            arr[left] <= arr[right] -> arr[left++]
            else -> arr[right++]
        }
    }
    for (i in start until end) arr[i] = tmp[i]
}
