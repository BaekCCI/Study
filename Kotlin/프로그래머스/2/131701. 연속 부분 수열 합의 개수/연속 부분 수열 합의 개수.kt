class Solution {
    fun solution(elements: IntArray): Int {
        var startIndex = 0
        var endIndex = 1
        var sum = elements[startIndex]
        val result: MutableSet<Int> = mutableSetOf()
        while (true) {
            if (endIndex == elements.size) {
                endIndex = 0
            }
            if (endIndex == startIndex) {
                result.add(sum)
                startIndex++
                if (startIndex > elements.size - 1) break
                sum = elements[startIndex]
                endIndex = startIndex + 1
            } else {
                result.add(sum)
                sum += elements[endIndex++]
            }

        }
        return result.size
    }
}