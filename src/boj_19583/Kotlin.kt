package boj_19583

import java.util.StringTokenizer

fun main() {
    var st = StringTokenizer(readln())
    val s = st.nextToken()
    val e = st.nextToken()
    val q = st.nextToken()

    val before = HashSet<String>()
    val after = HashSet<String>()
    var line = ""
    while (readlnOrNull()?.also { line = it } != null) {
        st = StringTokenizer(line)
        val time = st.nextToken()
        val nickname = st.nextToken()
        when {
            time <= s -> before.add(nickname)
            time in e..q -> after.add(nickname)
            else -> Unit
        }
    }

    var count = 0
    before.forEach { if (it in after) ++count }
    print(count)
}
