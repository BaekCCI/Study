fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }

    val amounts = IntArray(n) { readln().toInt() }
    var l = amounts.max()
    var r = amounts.sum()

    var answer = r

    while (l <= r) {
        val mid = (l + r) / 2

        var count = 1
        var cur = mid

        for (amount in amounts) {
            if (amount > cur) {
                count++
                cur = mid
            }
            cur -= amount
        }

        if (count > m) {
            l = mid + 1
        } else {
            answer = mid
            r = mid - 1
        }
    }
    println(answer)
}
