import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    val x = input.nextInt()
    val y = input.nextInt()

    val result = if (x > 0 && y > 0) 1
    else if (x < 0 && y > 0) 2
    else if (x < 0 && y < 0) 3
    else 4
    println(result)
}