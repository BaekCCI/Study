fun main() {
    val n = readln().toInt()
    val input: MutableList<Int> = mutableListOf()
    for (i in 1..n) {
        input.add(readln().toInt())
    }
    println(input.sorted().joinToString("\n"))
}