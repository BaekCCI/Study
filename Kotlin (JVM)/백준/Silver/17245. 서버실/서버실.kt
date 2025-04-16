fun main() {
    val n = readln().toInt()
    val computers = mutableListOf<Long>()
    for (i in 0 until n) {
        computers.addAll(readln().split(" ").map { it.toLong() })
    }
    val target = (computers.sum() + 1) / 2

    var r = 1L
    var l = computers.maxOrNull() ?: 0
    var answer = 0L

    while (r <= l) {
        var mid = (r + l) / 2

        var sum = 0L
        for (computer in computers) {
            if (computer < mid) {
                sum += computer
            } else {
                sum += mid
            }
        }
        if (sum >= target) {
            answer = mid
            l = mid - 1
        } else {
            r = mid + 1
        }
    }
    println(answer)
}