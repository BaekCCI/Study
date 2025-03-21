class Solution {
    fun solution(number: String, k: Int): String {
        var num = number.toMutableList()

        var dropCount = 0
        val que = ArrayDeque<Char>()

        for(i in num.indices){
            val target = num[i]
            
            while(que.isNotEmpty() && que.last()<target){
                if(dropCount>=k){
                    break
                }
                que.removeLast()
                dropCount++
            }
            que.add(target)        
        }
        while(dropCount<k){
            que.removeLast()
            dropCount++
        }
        return que.joinToString("")
    }
}