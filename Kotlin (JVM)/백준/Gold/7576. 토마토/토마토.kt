fun main() {
    val (m, n) = readln().split(" ").map { it.toInt() }
    val box = Array(n) { IntArray(m) }
    val tomatoes = ArrayDeque<IntArray>()
    val visit = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        box[i] = readln().split(" ").map { it.toInt() }.toIntArray()
        for (j in 0 until m) {
            if (box[i][j] == -1) {
                visit[i][j] = true
            } else if (box[i][j] == 1) {
                tomatoes.addLast(intArrayOf(i, j))
                visit[i][j] = true
            }
        }
    }

    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(0, 1))
    var day = -1

    while (tomatoes.isNotEmpty()) {
        day++
        val size = tomatoes.size
        for (i in 0 until size) {
            val (tc, tr) = tomatoes.removeFirst()
            for (dir in direction) {
                val nc = tc + dir[0]
                val nr = tr + dir[1]
                if (nc in 0 until n && nr in 0 until m && !visit[nc][nr]) {
                    visit[nc][nr] = true
                    tomatoes.add(intArrayOf(nc, nr))
                }
            }
        }
    }
    if (visit.all { it.all { it } }) {
        println(day)
    } else {
        println(-1)
    }
}