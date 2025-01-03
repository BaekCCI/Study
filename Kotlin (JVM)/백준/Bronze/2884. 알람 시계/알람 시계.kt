import java.util.*

fun main() {
    val input = Scanner(System.`in`)
    val time = input.nextLine().split(" ").map { it.toInt() }
    var h = time[0]
    var m = time[1]

    m -= 45
    if (m < 0) {
        h = (h - 1 + 24) % 24
        m += 60
    }
    println("$h $m")
}