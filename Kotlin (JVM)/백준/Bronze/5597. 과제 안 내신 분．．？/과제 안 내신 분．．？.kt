fun main() {
    val students: MutableList<Int> = (1..30).toMutableList()
    val attendance: MutableList<Int> = mutableListOf()
    for (i in 1..28) {
        attendance.add(readln().toInt())
    }
    val result = students.filter { it !in attendance }
    println(result.joinToString(separator = "\n"))
}