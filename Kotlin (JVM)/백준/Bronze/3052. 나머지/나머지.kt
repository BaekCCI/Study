fun main() {
    val numbers: MutableList<Int> = mutableListOf()
    for (i in 1..10) {
        numbers.add(readln().toInt() % 42)
    }
    println(numbers.distinct().size)
}