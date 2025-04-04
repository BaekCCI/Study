fun main() {
    val (r, c) = readln().split(" ").map { it.toInt() }
    val map = Array(r) { CharArray(c) }

    val waterMoves = ArrayDeque<IntArray>()
    val hedgehogMove = ArrayDeque<IntArray>()

    val hedgehogVisit = Array(r) { BooleanArray(c) }

    for (i in 0 until r) {
        map[i] = readln().toCharArray()
        for (j in 0 until c) {
            if (map[i][j] == '*') {
                waterMoves.add(intArrayOf(i, j))
            } else if (map[i][j] == 'S') {
                hedgehogMove.add(intArrayOf(i, j))
                hedgehogVisit[i][j] = true
            }
        }
    }

    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(0, 1))

    fun isValidMove(col: Int, row: Int): Boolean {
        return col in 0 until r && row in 0 until c && map[col][row] != 'X'
    }

    var time = 0
    while (hedgehogMove.isNotEmpty()) {
        time++
        //물 확산
        val wSize = waterMoves.size

        for (i in 0 until wSize) {
            val (wc, wr) = waterMoves.removeFirst()
            for (dir in direction) {
                val nc = wc + dir[0]
                val nr = wr + dir[1]
                if (isValidMove(nc, nr) && map[nc][nr] == '.') {
                    map[nc][nr] = '*'
                    waterMoves.addLast(intArrayOf(nc, nr))
                }
            }
        }
        //고슴도치 이동
        val hSize = hedgehogMove.size
        for (i in 0 until hSize) {
            val (hc, hr) = hedgehogMove.removeFirst()
            for (dir in direction) {
                val nc = hc + dir[0]
                val nr = hr + dir[1]
                if (isValidMove(nc, nr) && !hedgehogVisit[nc][nr] && map[nc][nr] != '*') {
                    if (map[nc][nr] == 'D') {
                        println(time)
                        return
                    }
                    hedgehogVisit[nc][nr] = true
                    hedgehogMove.addLast(intArrayOf(nc, nr))
                }
            }
        }
    }
    println("KAKTUS")
}