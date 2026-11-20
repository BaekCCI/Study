class Solution {
    fun solution(points: Array<IntArray>, routes: Array<IntArray>): Int {
        var answer = 0

        var activeRobot = routes.size

        val robots: Array<IntArray> = Array(activeRobot) { intArrayOf() }
        val nextRouteIdx: IntArray = IntArray(activeRobot) { 1 }

        for (i in routes.indices) {
            robots[i] = points[routes[i][0] - 1]
        }

        while (activeRobot > 1) {
            val dupCount: MutableMap<Pair<Int, Int>, Int> = mutableMapOf()

            for (i in routes.indices) {
                if (nextRouteIdx[i] == -1) continue

                val point = robots[i][0] to robots[i][1]
                dupCount[point] = dupCount.getOrDefault(point, 0) + 1

                if (dupCount[point] == 2) {
                    answer++
                }

                if (nextRouteIdx[i] == routes[i].size) {
                    activeRobot--
                    nextRouteIdx[i] = -1
                    continue
                }

                val (toR, toC) = points[routes[i][nextRouteIdx[i]] - 1]
                var (robotR, robotC) = point
                when {
                    robotR > toR -> robotR--
                    robotR < toR -> robotR++
                    robotC > toC -> robotC--
                    robotC < toC -> robotC++
                }
                robots[i] = intArrayOf(robotR, robotC)
                if (robotR == toR && robotC == toC) nextRouteIdx[i]++
            }
        }
        return answer
    }
}