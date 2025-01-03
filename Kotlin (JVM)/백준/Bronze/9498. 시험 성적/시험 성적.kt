import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    val a = input.nextInt()

    val result = when (a) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        in 60..69 -> "D"
        else -> "F"
    }
    println(result)
}