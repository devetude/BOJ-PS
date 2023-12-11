package boj_25206

fun main() {
    val records = buildList {
        repeat(times = 20) {
            val record = Record.of(readln())
            if (!record.isPassGrade()) add(record)
        }
    }
    val creditSum = records.sumOf { it.credit }
    val gradePointSum = records.sumOf { it.credit * it.gradePoint }
    val gradePointAverage = gradePointSum / creditSum

    println(gradePointAverage)
}

data class Record(
    private val subject: String,
    val credit: Double,
    private val grade: String,
    val gradePoint: Double
) {
    fun isPassGrade(): Boolean = grade == "P"

    companion object {
        private val GRADE_POINTS = hashMapOf(
            "A+" to 4.5,
            "A0" to 4.0,
            "B+" to 3.5,
            "B0" to 3.0,
            "C+" to 2.5,
            "C0" to 2.0,
            "D+" to 1.5,
            "D0" to 1.0,
            "F" to 0.0,
            "P" to 0.0
        )

        fun of(line: String): Record {
            val elements = line.split(" ")

            return Record(
                subject = elements[0],
                credit = elements[1].toDouble(),
                grade = elements[2],
                gradePoint = requireNotNull(GRADE_POINTS[elements[2]])
            )
        }
    }
}
