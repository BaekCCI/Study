class Solution {
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {
        var answer: Int = Int.MAX_VALUE
        
        var start = 1
        var end = 100_000
        
        while(start<=end){
            val mid = (start+end)/2
            
            var total = 0L
            for(i in diffs.indices){
                when{
                    diffs[i] <= mid ->{
                        total += times[i]   
                    }
                    diffs[i] > mid ->{
                       total += (times[i] + times[i-1]) * (diffs[i] - mid) + times[i]
                    }
                }
            }
            if(total > limit) {
                start = mid + 1
            }else{
                if(mid < answer) answer = mid
                end = mid-1
            }
        }
        
        return answer
    }
}