package boj_1931

fun main() {
    val n = readln().toInt()
    val schedules = List(n) {
        val row = readln().split(" ").map { it.toInt() }
        Schedule(startTime = row[0], endTime = row[1])
    }

    var lastEndTime = 0
    var availableMaxRoomCount = 0

    schedules.sorted()
        .forEach {
            if (lastEndTime <= it.startTime) {
                lastEndTime = it.endTime
                ++availableMaxRoomCount
            }
        }

    println(availableMaxRoomCount)
}

data class Schedule(val startTime: Int, val endTime: Int) : Comparable<Schedule> {
    override fun compareTo(other: Schedule): Int =
        if (endTime == other.endTime) startTime - other.startTime else endTime - other.endTime
}
