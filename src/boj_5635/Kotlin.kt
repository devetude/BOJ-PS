package boj_5635

import java.util.StringTokenizer

fun main() {
    val n = readln().toInt()
    val people = Array(n) { Person.INVALID }
    repeat(n) {
        val st = StringTokenizer(readln())
        val name = st.nextToken()
        val day = st.nextToken().toInt()
        val month = st.nextToken().toInt()
        val year = st.nextToken().toInt()
        people[it] = Person(name, day, month, year)
    }

    with(people.sortedWith(Person.BIRTH_ASC)) {
        println(last().name)
        print(first().name)
    }
}

data class Person(
    val name: String,
    val day: Int,
    val month: Int,
    val year: Int
) {
    companion object {
        val INVALID: Person = Person(name = "", day = 0, month = 0, year = 0)

        val BIRTH_ASC: Comparator<Person> =
            compareBy<Person> { it.year }.thenBy { it.month }.thenBy { it.day }
    }
}
