fun main() {
    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(0, 1))

    val t = readln().toInt()

    fun play() {
        val info = readln().split(" ").map { it.toInt() }
        val h = info[0]
        val w = info[1]
        val o = info[2]
        val f = info[3]
        val sx = info[4] - 1
        val sy = info[5] - 1
        val ex = info[6] - 1
        val ey = info[7] - 1

        val map = Array(h) { IntArray(w) }
        repeat(o) {
            val (x, y, oh) = readln().split(" ").map { it.toInt() }
            map[x - 1][y - 1] = oh
        }
        val visit = Array(h) { BooleanArray(w) }
        val que = ArrayDeque<IntArray>() // x,y,f

        que.add(intArrayOf(sx, sy, f))
        visit[sx][sy] = true

        if (sx == ex && sy == ey) {
            println("잘했어!!")
            return
        }

        while (que.isNotEmpty()) {
            val size = que.size

            for (i in 0 until size) {
                val (curX, curY, curF) = que.removeFirst()

                if (curF <= 0) continue

                val ch = map[curX][curY]
                for (dir in direction) {
                    val nx = curX + dir[0]
                    val ny = curY + dir[1]
                    if (nx in 0 until h && ny in 0 until w && !visit[nx][ny]) {
                        val nh = map[nx][ny]

                        val needF = maxOf(0, nh - ch)

                        if (curF >= needF) {
                            if (nx == ex && ny == ey) {
                                println("잘했어!!")
                                return
                            }
                            visit[nx][ny] = true
                            que.add(intArrayOf(nx, ny, curF - 1))
                        }
                    }
                }
            }
        }
        println("인성 문제있어??")
    }
    repeat(t) {
        play()
    }
}
