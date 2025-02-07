import kotlin.math.abs
class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var answer: Int = 100

        val graph = Array(n + 1) { mutableListOf<Int>() }

        wires.forEach {
            graph[it[0]].add(it[1])
            graph[it[1]].add(it[0])
        }
        wires.forEach {
            val net1 = bfs(n, it[0], it[1], graph)
            val net2 = bfs(n, it[1], it[0], graph)
            answer = minOf(answer, abs(net1 - net2))
        }

        return answer
    }

    fun bfs(n:Int, v1: Int, v2: Int, graph: Array<MutableList<Int>>): Int {
        val que = ArrayDeque<Int>()
        val visit = BooleanArray(n + 1)
        visit[v1] = true
        que.add(v1)
        var count = 1
        while (que.isNotEmpty()) {
            val value = que.removeFirst()

            graph[value].forEach {
                if (!visit[it] && it != v2) {
                    count++
                    visit[it] = true
                    que.add(it)
                }
            }
        }
        return count
    }
}