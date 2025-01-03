import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    val dice = input.nextLine().split(" ").map { it.toInt() }

    val count: MutableMap<Int, Int> = mutableMapOf()
    dice.forEach {
        count[it] = count.getOrDefault(it, 0) + 1
    }

    val result = when (count.size) {
        1 -> 10_000 + 1_000 * count.keys.first()
        2 -> {
            val temp = count.filter { it.value == 2 }.keys.first()
            1_000 + 100 * temp
        }

        else -> dice.max() * 100
    }

    println(result)
}