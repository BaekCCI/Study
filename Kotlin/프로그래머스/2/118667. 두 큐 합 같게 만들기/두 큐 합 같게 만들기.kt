class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val sum = queue1.sum().toLong() + queue2.sum().toLong()
        if (sum % 2 != 0L) return -1
        var target = sum / 2
        val que1 = ArrayDeque(queue1.toList())
        val que2 = ArrayDeque(queue2.toList())
        var sum1 = que1.sum().toLong()
        var sum2 = que2.sum().toLong()
        val maxCount = (queue1.size + queue2.size) * 2
        var count = 0
        while (count <= maxCount) {
            if (sum1 == target && sum2 == target) {
                return count
            }
            if (sum1 > target) {
                val temp = que1.removeFirst()
                que2.addLast(temp)
                sum1 -= temp
                sum2 += temp
            } else if (sum1 < target) {
                val temp = que2.removeFirst()
                que1.addLast(temp)
                sum2 -= temp
                sum1 += temp
            }
            count++
        }
        return -1
    }
}