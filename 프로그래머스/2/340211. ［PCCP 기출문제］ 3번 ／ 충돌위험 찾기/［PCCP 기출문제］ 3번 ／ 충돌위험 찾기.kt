class Solution {
    fun solution(points: Array<IntArray>, routes: Array<IntArray>): Int {
        var answer = 0

        val visitRoutes: Array<MutableList<IntArray>> = Array(routes.size) { mutableListOf() }

        for (i in routes.indices) {
            val route = routes[i]
            val visit = mutableListOf<IntArray>()
            var (curC, curR) = points[route[0] - 1]

            visit.add(intArrayOf(curC, curR))

            for (i in 1 until route.size) {
                val (toC, toR) = points[route[i] - 1]
                while (curC != toC || curR != toR) {
                    when {
                        curC < toC -> {
                            visit.add(intArrayOf(++curC, curR))
                            continue
                        }
                        curC > toC -> {
                            visit.add(intArrayOf(--curC, curR))
                            continue
                        }
                        curR < toR -> {
                            visit.add(intArrayOf(curC, ++curR))
                            continue
                        }
                        curR > toR -> {
                            visit.add(intArrayOf(curC, --curR))
                            continue
                        }
                    }
                }
            }
            visitRoutes[i] = visit
        }

        val maxLength = visitRoutes.maxOf { it.size }

        for (i in 0 until maxLength) {
            val dup: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()

            for (visit in visitRoutes) {
                if (visit.size <= i) continue
                val (curR, curC) = visit[i]
                dup[Pair(curR, curC)] = dup.getOrDefault(Pair(curR, curC), 0) + 1
            }
            answer += dup.filter{it.value > 1}.size
        }

        return answer
    }
}