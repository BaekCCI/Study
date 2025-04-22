import kotlin.math.abs
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    var brokenBtn = listOf<Char>()
    if (m != 0) {
        brokenBtn = readln().split(" ").map { it[0] }
    }

    fun getMinOfLargeCount(): Int {
        var cur = n
        while (cur <= 999_900) {
            if (cur.toString().any { it in brokenBtn }) {
                cur++
            } else {
                return cur.toString().length + (cur - n)
            }
        }
        return abs(n - 100)
    }

    fun getMaxOfSmallCount(): Int {
        var cur = n
        while (cur >= 0) {
            if (cur.toString().any { it in brokenBtn }) {
                cur--
            } else {
                return cur.toString().length + (n - cur)
            }
        }
        return abs(n - 100)
    }

    val answer = minOf(
        getMinOfLargeCount(), getMaxOfSmallCount(),
        abs(n - 100)
    )
    println(answer)
}