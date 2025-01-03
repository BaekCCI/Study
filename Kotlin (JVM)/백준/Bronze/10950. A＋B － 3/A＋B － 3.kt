import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextLine().toInt()
    val inputNum: MutableList<Pair<Int, Int>> = mutableListOf()

    for (i in 1..n) {
        val ab = sc.nextLine().split(" ").map { it.toInt() }
        inputNum.add(Pair(ab[0], ab[1]))
    }
    inputNum.forEach {
        println(it.first + it.second)
    }
}