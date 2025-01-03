import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    sc.nextLine()
    for (i in 1..n) {
        val input = sc.nextLine().split(" ").map { it.toInt() }
        println("Case #${i}: ${input[0] + input[1]}")
    }
}