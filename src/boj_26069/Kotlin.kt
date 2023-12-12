package boj_26069

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()

    val dancerNames = HashSet<String>()
    dancerNames.add("ChongChong")
    repeat(n) {
        val st = StringTokenizer(readln())
        val a = st.nextToken()
        val b = st.nextToken()

        if (a in dancerNames || b in dancerNames) {
            dancerNames.add(a)
            dancerNames.add(b)
        }
    }

    println(dancerNames.size)
}
