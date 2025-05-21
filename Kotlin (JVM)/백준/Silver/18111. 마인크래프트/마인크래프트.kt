fun main() {
    val (n, m, b) = readln().split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) }
    var maxH = 0
    var minH = 256
    for (i in 0 until n) {
        map[i] = readln().split(" ").map { it.toInt() }.toIntArray()
        maxH = maxOf(maxH, map[i].max())
        minH = minOf(minH, map[i].min())
    }
    
    var resultT = Int.MAX_VALUE
    var resultH = 0
    for (targetH in minH .. maxH) {
        var inventory = b
        var time = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                val h = map[i][j]
                if (h < targetH) {
                    time += targetH - h
                    inventory -= targetH - h
                } else if (h > targetH) {
                    time += 2 * (h - targetH)
                    inventory += h - targetH
                }
            }
        }
        if (inventory >= 0) {
            if (time <= resultT) {
                resultT = time
                resultH = maxOf(resultH, targetH)
            }
        }
    }
    println("$resultT $resultH")
}