fun main() {
    val nm = readln().split(" ").map { it.toInt() }
    val bag: MutableList<Int> = mutableListOf()
    for (i in 1..nm[0]) {
        bag.add(i)
    }

    for (i in 1..nm[1]) {
        val input = readln().split(" ").map { it.toInt() }
        val temp = bag[input[0]-1]
        bag[input[0]-1] = bag[input[1]-1]
        bag[input[1]-1] = temp
    }
    println(bag.joinToString(separator = " "))
}