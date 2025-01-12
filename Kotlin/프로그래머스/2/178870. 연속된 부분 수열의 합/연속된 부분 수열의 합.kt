class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf(0, sequence.size-1)
        var startIndex = 0
        var endIndex = 0
        var sum = sequence[endIndex]

        while (startIndex < sequence.size) {
            if (sum < k) {
                if(endIndex == sequence.size-1) break
                sum += sequence[++endIndex]
            }
            else{
                if(sum == k){
                    if (answer[1] - answer[0] > endIndex - startIndex) {
                        answer[0] = startIndex
                        answer[1] = endIndex
                    }
                }
                sum-=sequence[startIndex++]
            }
        }
        return answer
    }
}