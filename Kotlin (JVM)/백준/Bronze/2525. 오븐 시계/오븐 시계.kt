import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    val time = input.nextLine().split(" ").map { it.toInt() }
    val cookTime = input.nextInt()
    var h = time[0]
    var m = time[1]

    m = m + cookTime
    if (m >= 60) {
        h += m / 60
        m = m % 60
    }
    if (h >= 24) {
        h %= 24
    }
    println("$h $m")
}