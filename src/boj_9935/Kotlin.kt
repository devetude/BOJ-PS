package boj_9935

fun main() {
    val str = readln()
    val boomStr = readln()

    val sb = StringBuilder()
    str.forEach {
        sb.append(it)

        val startIdx = sb.length - boomStr.length
        if (startIdx < 0) return@forEach

        var shouldDelete = true
        for (i in boomStr.indices) {
            if (sb[startIdx + i] == boomStr[i]) continue

            shouldDelete = false
            break
        }

        if (shouldDelete) sb.deleteRange(startIdx, sb.length)
    }
    val result = if (sb.isEmpty()) "FRULA" else sb.toString()

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
