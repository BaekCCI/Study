class Solution {
    fun solution(elements: IntArray): Int {
        var startIndex = 0
        var endIndex = 0
        var sum = elements[endIndex]
        val result: MutableSet<Int> = mutableSetOf()
        val size = elements.size

        while (startIndex < size) {
            result.add(sum)
            endIndex = (endIndex + 1) % size
            sum += elements[endIndex]

            if (endIndex == startIndex) {
                endIndex = (startIndex + 1) % size
                sum = elements[endIndex]
                startIndex++
            }
        }
        return result.size
    }
}