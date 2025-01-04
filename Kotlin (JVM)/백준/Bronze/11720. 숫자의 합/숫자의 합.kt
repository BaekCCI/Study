fun main() {
    val n = readln().toInt()

    val numbers = readln().toList().map{it.digitToInt()}
    println(numbers.sum())
}