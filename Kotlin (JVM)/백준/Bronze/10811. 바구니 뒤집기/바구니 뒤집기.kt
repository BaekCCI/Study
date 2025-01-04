fun main() {
    val nm = readln().split(" ").map { it.toInt() }

    val bag : MutableList<Int> = (1..nm[0]).toMutableList()

    for (i in 1..nm[1]) {
        val input = readln().split(" ").map { it.toInt() }
        bag.subList(input[0] - 1, input[1]).reverse()
    }

    println(bag.joinToString (separator = " "))

}