fun main() {
    val chess = listOf(1, 1, 2, 2, 2, 8)
    val input = readln().split(" ").map { it.toInt() }
    val result: MutableList<Int> = mutableListOf()
    for (i in chess.indices) {
        result.add(chess[i] - input[i])
    }
    println(result.joinToString(" "))
}