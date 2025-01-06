fun main() {
    val input: MutableList<Int> = mutableListOf()

    for (i in 1..5) {
        input.add(readln().toInt())
    }
    input.sort()
    println(input.sum() / 5)
    println(input[2])
}