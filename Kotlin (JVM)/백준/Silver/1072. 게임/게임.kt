fun main() {
    var (x, y) = readln().split(" ").map { it.toLong() }
    val z = y * 100 / x

    var s = 1L
    var e = 1_000_000_000L
    var answer = -1L
    while (s <= e) {
        val mid = (s + e) / 2

        val newZ = (y + mid) * 100 / (x + mid)
        if (newZ == z) {
            s = mid + 1
        } else {
            answer = mid
            e = mid - 1
        }
    }
    println(answer)
}