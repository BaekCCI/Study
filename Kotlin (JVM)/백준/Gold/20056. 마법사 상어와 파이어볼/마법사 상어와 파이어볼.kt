val direction = arrayOf(
    intArrayOf(-1, 0),
    intArrayOf(-1, 1),
    intArrayOf(0, 1),
    intArrayOf(1, 1),
    intArrayOf(1, 0),
    intArrayOf(1, -1),
    intArrayOf(0, -1),
    intArrayOf(-1, -1)
)

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    //위치 (ri, ci), 질량 mi, 속력si, 방향di
    val balls = Array(m) { readln().split(" ").map { it.toInt() } }

    val que = ArrayDeque<IntArray>()
    balls.forEach {
        val (r, c, m, s, d) = it
        que.add(intArrayOf(r - 1, c - 1, m, s, d))
    }
    repeat(k) {
        val movedBalls: MutableMap<Pair<Int, Int>, MutableList<IntArray>> = mutableMapOf()

        val size = que.size
        repeat(size) {
            val (r, c, m, s, d) = que.removeFirst()
            val nr = (r + direction[d][0] * (s % n) + n) % n
            val nc = (c + direction[d][1] * (s % n) + n) % n
            movedBalls.getOrPut(nr to nc) { mutableListOf() }.add(intArrayOf(m, s, d))
        }

        for ((pos, balls) in movedBalls) {
            val count = balls.size
            if (count == 1) {
                val (m, s, d) = balls[0]
                que.add(intArrayOf(pos.first, pos.second, m, s, d))
                continue
            }

            val newM = balls.sumOf { it[0] } / 5
            if (newM == 0) continue
            val newS = balls.sumOf { it[1] } / count
            val isSameParity = balls.all { it[2] % 2 == 0 } || balls.all { it[2] % 2 == 1 }
            if (isSameParity) {
                for (newD in 0..6 step 2) {
                    que.add(intArrayOf(pos.first, pos.second, newM, newS, newD))
                }
                continue
            }
            for (newD in 1..7 step 2) {
                que.add(intArrayOf(pos.first, pos.second, newM, newS, newD))
            }
        }
    }
    val result = que.sumOf { it[2] }
    println(result)
}