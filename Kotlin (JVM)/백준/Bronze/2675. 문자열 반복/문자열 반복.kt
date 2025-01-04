fun main() {
    val n = readln().toInt()
    for (i in 1..n) {
        val input = readln().split(" ")
        val str = input[1].toList().joinToString("") { it.toString().repeat(input[0].toInt()) }
        println(str)
    }
}