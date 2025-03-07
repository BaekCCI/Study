fun main() {
    val (n, s) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }

    var answer = 100_001

    var l = 0
    var sum = 0

    for (r in 0 until n) {
        sum += numbers[r]
        while (sum >= s) {
            answer = minOf(answer, r - l + 1)
            sum -= numbers[l++]
        }
    }
    if (answer == 100_001) {
        println(0)
    } else {
        println(answer)
    }
}