class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        val max = tangerine.maxOrNull() ?: 0
        var count = IntArray(max + 1)

        tangerine.forEach {
            count[it] += 1
        }
        count.sortDescending()
        var sum = 0
        for(i in count.indices){
            sum+=count[i]
            answer++
            if(sum>=k)break
        }
        return answer
    }
}