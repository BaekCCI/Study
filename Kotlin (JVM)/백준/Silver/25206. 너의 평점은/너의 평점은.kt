import java.util.Scanner

fun main() {
    val sc = Scanner(System.`in`)

    var sum = 0.0
    var count = 0.0
    while (sc.hasNextLine()) {
        val input = sc.nextLine()
        if (input.isNotEmpty()) {
            val clearInput = input.split(" ")
            if (clearInput[2] != "P") {
                sum += clearInput[1].toDouble() * getScore(clearInput[2])
                count += clearInput[1].toDouble()
            }
        }
    }
    println(sum / count)
}

fun getScore(score: String): Double {
    return when (score) {
        "A+" -> 4.5
        "A0" -> 4.0
        "B+" -> 3.5
        "B0" -> 3.0
        "C+" -> 2.5
        "C0" -> 2.0
        "D+" -> 1.5
        "D0" -> 1.0
        else -> 0.0
    }
}