fun main() {
    val (k, n) = readln().split(" ").map { it.toInt() }

    val length = LongArray(k)
    for (i in 0 until k) {
        length[i] = readln().toLong()
    }
    length.sort()

    var low = 1L
    var high:Long = length.max()

    var answer = 0L

    while (low <= high) {
        val mid = (low + high) / 2
        val count = length.sumOf { it / mid }

        if (count >= n) {
            answer = maxOf(answer, mid)
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    println(answer)
}