import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    while (true) {
        val input = sc.nextLine().split(" ").map { it.toInt() }
        if (input[0] == 0 && input[1] == 0) return
        println(input[0] + input[1])
    }
}