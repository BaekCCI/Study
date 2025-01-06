fun main() {
    val n = readln().toInt()
    val num: MutableList<Int> = MutableList(n) { 0 }

    num.forEachIndexed { index, _ ->
        num[index] = readln().toInt()
    }
    println(num.sorted().joinToString("\n"))
}
