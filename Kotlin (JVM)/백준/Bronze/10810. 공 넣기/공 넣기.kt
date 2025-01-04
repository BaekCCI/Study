fun main() {
    val nm = readln().split(" ").map { it.toInt() }
    val bag: MutableList<Int> = MutableList(nm[0]) { 0 }

    for (i in 1..nm[1]) {
        val input = readln().split(" ").map { it.toInt() }
        for (i in input[0]..input[1]) {
            bag[i - 1] = input[2]
        }
    }
    println(bag.joinToString(separator = " "))
}