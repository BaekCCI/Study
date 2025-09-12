class Solution {
    fun solution(edges: Array<IntArray>): IntArray {

        val startCount = IntArray(1_000_001)
        val endCount = IntArray(1_000_001)

        for ((a, b) in edges) {
            startCount[a]++
            endCount[b]++
        }

        var newNode = 0
        var total = 0
        var eight = 0
        var stick = 0
        for (i in 1 until 1_000_001) {
            val s = startCount[i]
            val e = endCount[i]
            if (s > 1 && e == 0) {
                newNode = i
                total = s
                continue
            }
            if (s == 0 && e != 0) {
                stick++
            } else if (s == 2 && e >= 2) {
                eight++
            }
        }
        val result = intArrayOf(newNode, total - stick - eight, stick, eight)
        return result
    }
}