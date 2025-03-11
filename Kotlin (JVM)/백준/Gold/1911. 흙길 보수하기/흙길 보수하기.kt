fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    val ung = Array(n) { LongArray(2) }
    for (i in 0 until n) {
        ung[i] = readln().split(" ").map { it.toLong() }.toLongArray()
    }
    ung.sortBy { it[0] }

    var count = 0
    var lastIndex = 0L
    var startIndex = lastIndex
    ung.forEach {
        if (lastIndex <= it[0]) {
            lastIndex = it[0]
        }
        while (true) {
            startIndex = lastIndex
            if (lastIndex >= it[1]) {
                break
            } else {
                count++
                lastIndex = startIndex + l
            }
        }
    }
    println(count)
}