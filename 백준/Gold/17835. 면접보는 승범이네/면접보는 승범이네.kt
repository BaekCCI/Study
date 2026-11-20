import java.util.*

fun main() {
    val (N, M, K) = readln().split(" ").map { it.toInt() }

    val graph: Array<MutableList<Pair<Int, Int>>> = Array(N + 1) { mutableListOf() }

    repeat(M) {
        val (U, V, C) = readln().split(" ").map { it.toInt() }
        graph[V].add(U to C)
    }
    val cities = readln().split(" ").map { it.toInt() }

    val dArr = LongArray(N + 1) { Long.MAX_VALUE }
    val pq = PriorityQueue<Pair<Int, Long>>(compareBy { it.second }) //city, distance

    cities.forEach {
        pq.add(it to 0)
        dArr[it] = 0
    }

    while (pq.isNotEmpty()) {
        val (curN, distance) = pq.poll()

        if (distance > dArr[curN]) continue

        for ((n, d) in graph[curN]) {
            val newDis = distance + d
            if (newDis >= dArr[n]) continue

            dArr[n] = newDis
            pq.add(n to newDis)
        }
    }

    val maxDis = dArr.drop(1).max()
    val city = dArr.indexOfFirst { it == maxDis }
    println(city)
    println(maxDis)
}