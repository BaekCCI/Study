import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    while (sc.hasNextLine()) {
        val input = sc.nextLine()
        if (input == null || input == "") break
        val numbers = input.split(" ").map { it.toInt() }
        println(numbers[0] + numbers[1])
    }
}