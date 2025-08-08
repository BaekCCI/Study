fun main() {
    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(0, 1))
    val field = Array(12) { readln().toCharArray() }

    fun bfs(target: Char, pos: IntArray): Boolean {
        val que = ArrayDeque<IntArray>()
        val visit = Array(12) { BooleanArray(6) }
        val puyo: MutableList<IntArray> = mutableListOf()

        visit[pos[0]][pos[1]] = true
        que.add(pos)
        puyo.add(pos)

        while (que.isNotEmpty()) {
            val (c, r) = que.removeFirst()

            for (dir in direction) {
                val nc = c + dir[0]
                val nr = r + dir[1]
                if (nc in 0 until 12 && nr in 0 until 6 && !visit[nc][nr]) {
                    visit[nc][nr] = true
                    if (field[nc][nr] == target) {
                        que.add(intArrayOf(nc, nr))
                        puyo.add(intArrayOf(nc, nr))
                    }
                }
            }
        }
        if (puyo.size >= 4) {
            puyo.forEach { (c, r) ->
                field[c][r] = '.'
            }
            return true
        }
        return false
    }

    var result = 0
    fun movePuyo() {
        for (j in 0 until 6) {
            for (i in 11 downTo 0) {
                val ch = field[i][j]
                if (ch != '.') {
                    var c = i
                    while (c + 1 < 12 && field[c+1][j] == '.') {
                        c++
                    }
                    if (c != i) {
                        field[c][j] = ch
                        field[i][j] = '.'
                    }
                }
            }
        }
    }

    while (true) {
        var flag = false
        for (i in 0 until 12) {
            for (j in 0 until 6) {
                if (field[i][j] != '.') {
                    if (bfs(field[i][j], intArrayOf(i, j))) {
                        flag = true
                    }
                }
            }
        }
        if (!flag) break
        movePuyo()
        result++
    }
    println(result)
}