fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val ladder = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val snakes = Array(m) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val dices = intArrayOf(1, 2, 3, 4, 5, 6)

    val que = ArrayDeque<IntArray>()
    val visit = BooleanArray(101)
    que.add(intArrayOf(1, 0))
    visit[1] = true
    while (que.isNotEmpty()) {
        val (cur, count) = que.removeFirst()
        if (cur == 100) {
            println(count)
            return
        }
        dices.forEach { dice ->
            val next = cur + dice
            if (next <= 100 && !visit[next]) {
                visit[next] = true
                val goLadder = ladder.find { it[0] == next }
                val goSnake = snakes.find { it[0] == next }
                if (goLadder != null) {
                    visit[goLadder[1]] = true
                    que.add(intArrayOf(goLadder[1], count + 1))
                } else if (goSnake != null) {
                    visit[goSnake[1]] = true
                    que.add(intArrayOf(goSnake[1], count + 1))
                } else {
                    que.add(intArrayOf(next, count + 1))
                }
            }
        }
    }
}