import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    sc.nextLine()
    
    for (i in 1..n) {
        println(String.format("%${n}s", "*".repeat(i)))
    }
}