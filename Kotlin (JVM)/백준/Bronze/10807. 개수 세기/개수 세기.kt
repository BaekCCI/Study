fun main() {
    val n = readln().toInt()
    val inputNum = readln().split(" ").map { it.toInt() }
    val matchNum = readln().toInt()

    println(inputNum.filter { it == matchNum }.size)
}