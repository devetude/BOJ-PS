package boj_2800

import java.util.LinkedList
import java.util.Stack
import java.util.TreeSet

lateinit var exp: String

val parentheses: LinkedList<Pair<Int, Int>> = LinkedList()
val results: TreeSet<String> = TreeSet()

fun main() {
    exp = readln()

    val stack = Stack<Char>()
    val lefts = Stack<Int>()
    for (i in exp.indices) {
        val c = exp[i]
        if (c != ')') {
            if (c == '(') lefts.push(i)
            stack.push(c)
            continue
        }

        while (stack.pop() != '(') Unit
        parentheses.add(lefts.pop() to i)
    }

    for (count in 1..parentheses.size) buildComb(count)

    System.out.bufferedWriter().use {
        it.write(results.joinToString(separator = "\n"))
        it.flush()
    }
}

fun buildComb(
    count: Int,
    i: Int = 0,
    filteredParentheses: LinkedList<Pair<Int, Int>> = LinkedList()
) {
    if (count == 0) {
        val filters = filteredParentheses.toSet()
        val result = buildString { exp.forEachIndexed { i, c -> if (i !in filters) append(c) } }
        results.add(result)
        return
    }

    for (j in i until parentheses.size) {
        val newFilteredParentheses = LinkedList(filteredParentheses)
        newFilteredParentheses.add(parentheses[j])
        buildComb(count = count - 1, i = j + 1, newFilteredParentheses)
    }
}

fun LinkedList<Pair<Int, Int>>.toSet(): Set<Int> {
    val set = HashSet<Int>(p0 = size shl 1)
    forEach { (first, second) ->
        set.add(first)
        set.add(second)
    }

    return set
}
