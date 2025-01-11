
class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {

        var answer: IntArray = intArrayOf(0, sequence.size-1)
        var startIndex = 0
        var endIndex = 0
        var result = sequence[endIndex]
        while (startIndex < sequence.size) {
            if (result < k) {
                if (endIndex == sequence.size - 1) break
                endIndex++
                result += sequence[endIndex]
            } else {
                if (result == k) {
                    if(answer[1]-answer[0]>endIndex-startIndex){
                        answer[0] = startIndex
                        answer[1] = endIndex   
                    }
                }
                result -= sequence[startIndex]
                startIndex++
            }
        }

        return answer
    }
}