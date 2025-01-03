import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    val n = input.nextInt()

    for (i in 1..9) {
        println("$n * $i = ${n * i}")
    }
}