import kotlin.math.sqrt

class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {

        val minA = arrayA.minOrNull() ?: 0
        val minB = arrayB.minOrNull() ?: 0
        var answer: Int = 0

        val sqrtA = sqrt(minA.toDouble()).toInt()
        val dividerA: MutableSet<Int> = mutableSetOf()

        for (i in 1..sqrtA) {
            if (minA % i == 0) {
                if (arrayA.filter { it % i == 0 }.size == arrayA.size) {
                    dividerA.add(i)
                }
                if (arrayA.filter { it % (minA / i) == 0 }.size == arrayA.size) {
                    dividerA.add(minA / i)
                }
            }
        }

        val sqrtB = sqrt(minB.toDouble()).toInt()
        val dividerB: MutableSet<Int> = mutableSetOf()

        for (i in 1..sqrtB) {
            if (minB % i == 0) {
                if (arrayB.filter { it % i == 0 }.size == arrayB.size) {
                    dividerB.add(i)
                }
                if (arrayB.filter { it % (minB / i) == 0 }.size == arrayB.size) {
                    dividerB.add(minB / i)
                }
            }
        }
        dividerA.forEach { divider ->
            if (arrayB.filter { it % divider != 0 }.size == arrayB.size) {
                if (answer < divider) {
                    answer = divider
                }
            }
        }
        dividerB.forEach { divider ->
            if (arrayA.filter { it % divider != 0 }.size == arrayA.size) {
                if (answer < divider) {
                    answer = divider
                }
            }
        }
        return answer
    }
}