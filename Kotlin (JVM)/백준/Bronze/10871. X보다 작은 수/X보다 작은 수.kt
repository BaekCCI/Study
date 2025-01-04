fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }

    println(numbers.filter { it < input[1] }.joinToString(separator = " "))
}