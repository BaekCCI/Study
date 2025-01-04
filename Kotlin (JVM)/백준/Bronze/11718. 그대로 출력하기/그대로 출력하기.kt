
import java.util.Scanner

fun main() {
    val str: MutableList<String> = mutableListOf()
    val sc = Scanner(System.`in`)
    while (sc.hasNextLine()) {
        val input = sc.nextLine()
        if (input.isNotEmpty()){
            str.add(input)
        }
    }
    println(str.joinToString("\n"))
}