fun main() {
    val n = readln().toInt()
    val map = Array(n) { IntArray(n) }
    for (i in 0 until n) {
        map[i] = readln().split(" ").map { it.toInt() }.toIntArray()

    }

    fun moveUp(board: Array<IntArray>): Array<IntArray> {
        for (r in 0 until n) {
            val column = mutableListOf<Int>()
            for (c in 0 until n) {
                if (board[c][r] != 0) {
                    column.add(board[c][r])
                }
            }
            val result = mutableListOf<Int>()
            var i = 0
            while (i < column.size) {
                if (i + 1 < column.size && column[i] == column[i + 1]) {
                    result.add(column[i] * 2)
                    i += 2
                } else {
                    result.add(column[i])
                    i++
                }
            }
            while (result.size < n) {
                result.add(0)
            }
            for (c in 0 until n) {
                board[c][r] = result[c]
            }
        }
        return board
    }

    fun moveDown(board: Array<IntArray>): Array<IntArray> {
        for (r in 0 until n) {
            val column = mutableListOf<Int>()
            for (c in n - 1 downTo 0) {
                if (board[c][r] != 0) {
                    column.add(board[c][r])
                }
            }
            val result = mutableListOf<Int>()
            var i = 0
            while (i < column.size) {
                if (i + 1 < column.size && column[i] == column[i + 1]) {
                    result.add(column[i] * 2)
                    i += 2
                } else {
                    result.add(column[i])
                    i++
                }
            }
            while (result.size < n) {
                result.add(0)
            }
            for (c in 0 until n) {
                board[c][r] = result[n - c - 1]
            }
        }
        return board
    }

    fun moveLeft(board: Array<IntArray>): Array<IntArray> {
        for (c in 0 until n) {
            val row = mutableListOf<Int>()
            for (r in 0 until n) {
                if (board[c][r] != 0) {
                    row.add(board[c][r])
                }
            }
            val result = mutableListOf<Int>()
            var i = 0
            while (i < row.size) {
                if (i + 1 < row.size && row[i] == row[i + 1]) {
                    result.add(row[i] * 2)
                    i += 2
                } else {
                    result.add(row[i])
                    i++
                }
            }
            while (result.size < n) {
                result.add(0)
            }
            for (r in 0 until n) {
                board[c][r] = result[r]
            }
        }
        return board
    }

    fun moveRight(board: Array<IntArray>): Array<IntArray> {
        for (c in 0 until n) {
            val row = mutableListOf<Int>()
            for (r in n - 1 downTo 0) {
                if (board[c][r] != 0) {
                    row.add(board[c][r])
                }
            }
            val result = mutableListOf<Int>()
            var i = 0
            while (i < row.size) {
                if (i + 1 < row.size && row[i] == row[i + 1]) {
                    result.add(row[i] * 2)
                    i += 2
                } else {
                    result.add(row[i])
                    i++
                }
            }
            while (result.size < n) {
                result.add(0)
            }
            for (r in 0 until n) {
                board[c][r] = result[n - r - 1]
            }
        }
        return board
    }

    var answer = 0
    fun play(count: Int, board: Array<IntArray>) {
        if (count == 5) {
            answer = maxOf(board.maxOf { it.max() }, answer)
            return
        }
        play(count + 1, moveUp(Array(board.size) { board[it].clone() }))
        play(count + 1, moveDown(Array(board.size) { board[it].clone() }))
        play(count + 1, moveLeft(Array(board.size) { board[it].clone() }))
        play(count + 1, moveRight(Array(board.size) { board[it].clone() }))
    }
    play(0, map)
    println(answer)
}