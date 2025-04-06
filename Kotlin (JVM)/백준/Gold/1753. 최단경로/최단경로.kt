import java.util.PriorityQueue

fun main() {
    val (vNum, eNum) = readln().split(" ").map { it.toInt() }
    val start = readln().toInt() - 1
    val graph = Array(vNum) { mutableListOf<IntArray>() }
    for (i in 0 until eNum) {
        val (u, v, w) = readln().split(" ").map { it.toInt() }
        graph[u - 1].add(intArrayOf(v - 1, w))
    }
    val pQue = PriorityQueue(compareBy<IntArray> { it[1] })
    pQue.add(intArrayOf(start, 0))

    val pathSum = IntArray(vNum) { Int.MAX_VALUE }
    pathSum[start] = 0

    while (pQue.isNotEmpty()) {
        val (cur, curSum) = pQue.poll()

        if (curSum > pathSum[cur]) continue

        for ((next, nextDis) in graph[cur]) {
            val nSum = curSum + nextDis

            if (pathSum[next] > nSum) {
                pQue.add(intArrayOf(next, nSum))
                pathSum[next] = nSum
            }
        }
    }
    for (dis in pathSum) {
        println(if (dis == Int.MAX_VALUE) "INF" else dis)
    }
}