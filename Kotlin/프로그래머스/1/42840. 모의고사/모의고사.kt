class Solution {
    fun solution(answers: IntArray): IntArray {
        var count :MutableMap<Int,Int> = mutableMapOf()
        val first = intArrayOf(1,2,3,4,5)
        val second = intArrayOf(2,1,2,3,2,4,2,5)
        val third = intArrayOf(3,3,1,1,2,2,4,4,5,5)
        
        for(i in answers.indices){
            if(answers[i] == first[i%(first.size)]){
                count[1] = count.getOrDefault(1,0)+1
            }
            if(answers[i] == second[i%(second.size)]){
                count[2] = count.getOrDefault(2,0)+1
            }
            if(answers[i] == third[i%(third.size)]){
                count[3] = count.getOrDefault(3,0)+1
            }
        }
        val max = count.maxOf{it.value}
        val answer = count.filter{it.value == max}.map{it.key}.sorted().toIntArray()
        
    
        return answer
    }
}