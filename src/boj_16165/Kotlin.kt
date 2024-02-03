package boj_16165

import java.util.LinkedList
import java.util.StringTokenizer

fun main() {
    val st = StringTokenizer(readln())
    val n = st.nextToken().toInt()
    val m = st.nextToken().toInt()

    val teamToMembers = HashMap<String, LinkedList<String>>()
    val memberToTeam = HashMap<String, String>()
    repeat(n) {
        val team = readln()
        repeat(readln().toInt()) {
            val member = readln()
            teamToMembers[team] = teamToMembers.getOrDefault(team, LinkedList())
                .apply { add(member) }
            memberToTeam[member] = team
        }
    }

    val result = buildString {
        repeat(m) {
            val input = readln()
            if (readln() == "0") {
                teamToMembers[input]?.apply { sort() }?.forEach(::appendLine)
            } else {
                appendLine(memberToTeam[input])
            }
        }
    }

    System.out.bufferedWriter().use {
        it.write(result)
        it.flush()
    }
}
