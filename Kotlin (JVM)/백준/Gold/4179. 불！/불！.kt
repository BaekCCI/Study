fun main() {
    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    val (r, c) = readln().split(" ").map { it.toInt() }

    val map = Array(r) { CharArray(c) }
    val fQue = ArrayDeque<IntArray>()
    val jQue = ArrayDeque<IntArray>()
    val visit = Array(r) { BooleanArray(c) }

    for (i in 0 until r) {
        val input = readln().toCharArray()
        map[i] = input
        for (j in 0 until c) {
            if (input[j] == 'F') fQue.add(intArrayOf(i, j))
            if (input[j] == 'J') {
                jQue.add(intArrayOf(i, j))
                visit[i][j] = true
            }
        }
    }

    val (sr, sc) = jQue.first()
    if (sr == 0 || sr == r - 1 || sc == 0 || sc == c - 1) {
        println(1)
        return
    }

    var count = 1
    while (jQue.isNotEmpty()) {
        val fSize = fQue.size
        val jSize = jQue.size

        for (i in 0 until fSize) {
            val (fr, fc) = fQue.removeFirst()
            for (dir in direction) {
                val nr = fr + dir[0]
                val nc = fc + dir[1]
                if (nr in 0 until r && nc in 0 until c) {
                    if (map[nr][nc] != '#' && map[nr][nc] != 'F') {
                        map[nr][nc] = 'F'
                        fQue.add(intArrayOf(nr, nc))
                    }
                }
            }
        }

        for (i in 0 until jSize) {
            val (jr, jc) = jQue.removeFirst()
            if (jr == 0 || jr == r - 1 || jc == 0 || jc == c - 1) {
                println(count)
                return
            }
            for (dir in direction) {
                val nr = jr + dir[0]
                val nc = jc + dir[1]
                if (nr in 0 until r && nc in 0 until c && !visit[nr][nc] && map[nr][nc] == '.') {
                    visit[nr][nc] = true
                    jQue.add(intArrayOf(nr, nc))
                }
            }
        }
        count++
    }
    println("IMPOSSIBLE")
}