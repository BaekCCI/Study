import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextLine().toInt()
    var result = 0

    for (i in 1..n) {
        result += i
    }
    println(result)
}