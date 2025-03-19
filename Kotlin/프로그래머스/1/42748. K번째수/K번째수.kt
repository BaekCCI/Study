class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()
        
        for((i,j,k) in commands){
            val target = array.sliceArray(i-1..j-1).sorted()
            answer.add(target[k-1])
        }
        return answer.toIntArray()
    }
}