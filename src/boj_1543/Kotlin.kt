package boj_1543

fun main() {
    val doc = readln()
    val word = readln()

    var s = 0
    var count = 0
    while (s < doc.length) {
        var isMatched = true
        for (i in word.indices) {
            val j = s + i
            if (doc.lastIndex < j || doc[j] != word[i]) {
                isMatched = false
                break
            }
        }
        s += if (isMatched) {
            ++count
            word.length
        } else {
            1
        }
    }

    print(count)
}
