import java.util.*

class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val roadMap: MutableMap<Int, MutableList<Pair<Int, Int>>> = mutableMapOf()
        road.forEach {
            val (a, b, t) = it
            roadMap.getOrPut(a) { mutableListOf() }.add(b to t)
            roadMap.getOrPut(b) { mutableListOf() }.add(a to t)
        }

        val pq: PriorityQueue<Pair<Int, Int>> = PriorityQueue(compareBy { it.second })
        pq.offer(1 to 0)
        val array = IntArray(N + 1) { Int.MAX_VALUE }
        array[1] = 0

        while (pq.isNotEmpty()) {
            val (curN, curT) = pq.poll()

            roadMap[curN]?.forEach { (b, time) ->
                val total = curT + time
                if (array[b] > total) {
                    array[b] = total
                    pq.offer(b to total)
                }
            }
        }

        return array.filter { it <= k }.size
    }
}