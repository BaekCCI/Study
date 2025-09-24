fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }

    val heights = readln().split(" ").map { it.toLong() }

    val dif = LongArray(n - 1)

    for (i in 0 until n - 1) {
        dif[i] = heights[i + 1] - heights[i]
    }
    val sorted = dif.sortedDescending()


    var result = sorted.sum()
    for(i in 0 until k-1){
        result -= sorted[i]
    }
    println(result)

}