fun main() {
    val m = readln().toInt()
    val target = Array(m) { readln().split(" ").map { it.toInt() } }
    val n = readln().toInt()
    val pic = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val move = Array(n - 1) { IntArray(2) } //x,y

    var prev = target.first()
    for (i in 1 until target.size) {
        val cur = target[i]
        move[i - 1] = intArrayOf(cur[0] - prev[0], cur[1] - prev[1])
        prev = cur
    }

    fun find(x: Int, y: Int): Boolean {
        pic.forEach {
            if (it[0] == x && it[1] == y) return true
        }
        return false
    }

    fun isStar(startPoint: IntArray): Boolean {
        var (curX, curY) = startPoint

        for ((dx, dy) in move) {
            val nx = curX + dx
            val ny = curY + dy
            if (find(nx, ny)) {
                curX = nx
                curY = ny
                continue
            } else return false
        }
        return true
    }

    for (star in pic) {
        if (isStar(star)) {
            println("${star[0] - target[0][0]} ${star[1] - target[0][1]}")
            return
        }
    }
}
