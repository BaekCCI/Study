import java.util.*

fun main() {
    val (V, E) = readln().split(" ").map { it.toInt() }
    val K = readln().toInt()

    val graph: Array<MutableList<Pair<Int, Int>>> = Array(V + 1) { mutableListOf() }

    repeat(E) {
        val (u, v, w) = readln().split(" ").map { it.toInt() }
        graph[u].add(v to w)
    }

    val dArr = IntArray(V + 1) { Int.MAX_VALUE }
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second }) // 노드, 가중치
    dArr[K] = 0
    pq.add(Pair(K, 0))

    while (pq.isNotEmpty()) {
        val (curN, curW) = pq.poll()
    
        if (curW > dArr[curN]) continue

        for ((node, weight) in graph[curN]) {
            if (curW + weight >= dArr[node]) continue

            dArr[node] = curW + weight
            pq.add(Pair(node, curW + weight))
        }
    }
    dArr.drop(1).forEach {
        println(if (it == Int.MAX_VALUE) "INF" else it)
    }
}
