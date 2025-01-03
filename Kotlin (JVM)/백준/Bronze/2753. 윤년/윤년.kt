import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    val a = input.nextInt()

    val result = if (a % 400 == 0) 1
    else if (a % 4 == 0 && a % 100 != 0) 1
    else 0
    println(result)
}