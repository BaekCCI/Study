import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val totalPrice = sc.nextInt()
    val productCount = sc.nextInt()
    sc.nextLine()
    var purchasePrice = 0

    for (i in 1..productCount) {
        val input = sc.nextLine().split(" ").map { it.toInt() }
        purchasePrice += input[0] * input[1]
    }
    val result = if (totalPrice == purchasePrice) "Yes"
    else "No"
    println(result)

}