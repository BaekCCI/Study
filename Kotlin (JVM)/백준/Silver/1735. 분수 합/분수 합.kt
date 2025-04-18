fun main() {
    val (x1, y1) = readln().split(" ").map { it.toInt() }
    val (x2, y2) = readln().split(" ").map { it.toInt() }

    val resultX = x1 * y2 + x2 * y1
    val resultY = y1 * y2

    fun gcd(a: Int, b: Int): Int {
        if (b == 0) return a
        return gcd(b, a % b)
    }
    val divisor = gcd(resultX, resultY)

    println("${resultX / divisor} ${resultY / divisor}")
}