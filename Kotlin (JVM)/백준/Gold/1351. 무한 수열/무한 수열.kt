fun main() {
    val (n, p, q) = readln().split(" ").map { it.toLong() }
    val a = mutableMapOf<Long, Long>()
    a[0] = 1
    fun getAN(targetN: Long): Long {
        if (targetN == 0L) return 1

        if (a.containsKey(targetN)) return a[targetN]!!

        val calculate = getAN(targetN / p) + getAN(targetN / q)
        a[targetN] = calculate
        return calculate
    }
    println(getAN(n))
}