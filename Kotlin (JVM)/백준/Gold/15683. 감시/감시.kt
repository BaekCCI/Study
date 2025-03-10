fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(m) }
    val cctvs = mutableListOf<IntArray>() // 좌표, cctv#, #case

    var zeroCount = 0
    for (i in 0 until n) {
        graph[i] = readln().split(" ").map { it.toInt() }.toIntArray()
        for (j in 0 until m) {
            when (graph[i][j]) {
                1 -> cctvs.add(intArrayOf(i, j, 1, 4))
                2 -> cctvs.add(intArrayOf(i, j, 2, 2))
                3 -> cctvs.add(intArrayOf(i, j, 3, 4))
                4 -> cctvs.add(intArrayOf(i, j, 4, 4))
                5 -> cctvs.add(intArrayOf(i, j, 5, 1))
                0 -> zeroCount++
            }
        }
    }
    if (cctvs.isEmpty()) {
        println(zeroCount)
        return
    }

    fun isValidMove(x: Int, y: Int): Boolean {
        return x in 0 until n && y in 0 until m && graph[x][y] != 6
    }

    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    fun goUp(x: Int, y: Int, tempGraph: Array<IntArray>): Array<IntArray> {
        var nx = x
        var ny = y
        while (true) {
            nx += direction[0][0]
            ny += direction[0][1]
            if (isValidMove(nx, ny)) {
                if (tempGraph[nx][ny] == 0) {
                    tempGraph[nx][ny] = -1
                }
            } else {
                break
            }
        }
        return tempGraph
    }

    fun goDown(x: Int, y: Int, tempGraph: Array<IntArray>): Array<IntArray> {
        var nx = x
        var ny = y
        while (true) {
            nx += direction[1][0]
            ny += direction[1][1]
            if (isValidMove(nx, ny)) {
                if (tempGraph[nx][ny] == 0) {
                    tempGraph[nx][ny] = -1
                }
            } else {
                break
            }
        }
        return tempGraph
    }

    fun goLeft(x: Int, y: Int, tempGraph: Array<IntArray>): Array<IntArray> {
        var nx = x
        var ny = y
        while (true) {
            nx += direction[2][0]
            ny += direction[2][1]
            if (isValidMove(nx, ny)) {
                if (tempGraph[nx][ny] == 0) {
                    tempGraph[nx][ny] = -1
                }
            } else {
                break
            }
        }
        return tempGraph
    }

    fun goRight(x: Int, y: Int, tempGraph: Array<IntArray>): Array<IntArray> {
        var nx = x
        var ny = y
        while (true) {
            nx += direction[3][0]
            ny += direction[3][1]
            if (isValidMove(nx, ny)) {
                if (tempGraph[nx][ny] == 0) {
                    tempGraph[nx][ny] = -1
                }
            } else {
                break
            }
        }
        return tempGraph
    }

    //상, 하, 좌, 우
    fun c1(x: Int, y: Int, case: Int, tempGraph: Array<IntArray>): Array<IntArray> {
        var result: Array<IntArray> = arrayOf()
        when (case) {
            0 -> result = goUp(x, y, tempGraph)
            1 -> result = goDown(x, y, tempGraph)
            2 -> result = goLeft(x, y, tempGraph)
            3 -> result = goRight(x, y, tempGraph)
        }
        return result
    }

    // 0 -> 상하, 1->좌우
    fun c2(x: Int, y: Int, case: Int, tempGraph: Array<IntArray>): Array<IntArray> {
        var result: Array<IntArray> = arrayOf()
        when (case) {
            0 -> {
                result = goUp(x, y, tempGraph)
                result = goDown(x, y, result)
            }

            1 -> {
                result = goLeft(x, y, tempGraph)
                result = goRight(x, y, result)
            }
        }
        return result
    }

    // 0->상좌, 1->좌하, 2->하우, ->우상
    fun c3(x: Int, y: Int, case: Int, tempGraph: Array<IntArray>): Array<IntArray> {
        var result: Array<IntArray> = arrayOf()
        when (case) {
            0 -> {
                result = goUp(x, y, tempGraph)
                result = goLeft(x, y, result)
            }

            1 -> {
                result = goLeft(x, y, tempGraph)
                result = goDown(x, y, result)
            }

            2 -> {
                result = goDown(x, y, tempGraph)
                result = goRight(x, y, result)
            }

            3 -> {
                result = goRight(x, y, tempGraph)
                result = goUp(x, y, result)
            }
        }
        return result
    }

    // 0-> 상좌우, 1-> 상좌하, 2-> 좌하우, 3-> 하우상
    fun c4(x: Int, y: Int, case: Int, tempGraph: Array<IntArray>): Array<IntArray> {
        var result: Array<IntArray> = arrayOf()
        when (case) {
            0 -> {
                result = goUp(x, y, tempGraph)
                result = goLeft(x, y, result)
                result = goRight(x, y, result)
            }

            1 -> {
                result = goUp(x, y, tempGraph)
                result = goLeft(x, y, result)
                result = goDown(x, y, result)
            }

            2 -> {
                result = goLeft(x, y, tempGraph)
                result = goDown(x, y, result)
                result = goRight(x, y, result)
            }

            3 -> {
                result = goDown(x, y, tempGraph)
                result = goRight(x, y, result)
                result = goUp(x, y, result)
            }
        }
        return result
    }

    fun c5(x: Int, y: Int, case: Int, tempGraph: Array<IntArray>): Array<IntArray> {
        var result: Array<IntArray> = goUp(x, y, tempGraph)
        result = goDown(x, y, result)
        result = goLeft(x, y, result)
        result = goRight(x, y, result)
        return result
    }

    fun play(tempGraph: Array<IntArray>, depth: Int) {
        if (depth >= cctvs.size) {
            zeroCount = minOf(zeroCount, tempGraph.sumOf { row -> row.count { it == 0 } })
        } else {
            val x = cctvs[depth][0]
            val y = cctvs[depth][1]
            val cctv = cctvs[depth][2]
            for (i in 0 until cctvs[depth][3]) {
                val tmp = Array(tempGraph.size){tempGraph[it].clone()}
                when (cctv) {
                    1 -> {
                        play(c1(x, y, i, tmp), depth + 1)
                    }
                    2 -> {
                        play(c2(x, y, i, tmp), depth + 1)
                    }
                    3 -> {
                        play(c3(x, y, i, tmp), depth + 1)
                    }
                    4 -> {
                        play(c4(x, y, i, tmp), depth + 1)
                    }
                    5 -> {
                        play(c5(x, y, i, tmp), depth + 1)
                    }
                }
            }
        }
    }
    play(graph, 0)
    println(zeroCount)
}