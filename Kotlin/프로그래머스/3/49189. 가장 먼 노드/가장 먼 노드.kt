class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0
        val que = ArrayDeque<Int>() //인접 노드 저장
        val visit = BooleanArray(n + 1) { false } //방문 여부
        val edges: MutableMap<Int, MutableSet<Int>> = mutableMapOf()
        edge.forEach {
            edges.getOrPut(it[0]) { mutableSetOf() }.add(it[1])
            edges.getOrPut(it[1]) { mutableSetOf() }.add(it[0])
        }
        //초깃값 설정
        que.addLast(1)
        visit[1] = true
        var depth = 0
        val depthOfNodes: MutableMap<Int, MutableSet<Int>> = mutableMapOf()// key = depth, value = nodes
        depthOfNodes[depth] = mutableSetOf(1)

        while (que.isNotEmpty()) {
            depth++
            val size = que.size

            for (i in 0 until size) {
                val value = que.removeFirst()
                edges[value]?.forEach {
                    if (!visit[it]) {
                        que.addLast(it)
                        visit[it] = true
                        depthOfNodes.getOrPut(depth) { mutableSetOf() }.add(it)
                    }
                }
            }
        }
        val maxDepth = depthOfNodes.maxOf { it.key }
        answer = depthOfNodes[maxDepth]!!.size
        return answer
    }
}