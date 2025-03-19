import kotlin.math.abs

class Solution {
    fun solution(N: Int, number: Int): Int {
        var answer = 0
        val dp= Array(9){mutableSetOf<Int>()}
        
        for(i in 1 until 9){
            dp[i].add((N.toString().repeat(i)).toInt())
            
            for(j in 1 .. i/2){
                for(dpj in dp[j]){
                    for(dpji in dp[i-j]){
                        dp[i].add(dpj+dpji)
                        dp[i].add(dpj*dpji)
                        if(dpj - dpji != 0){
                            dp[i].add(abs(dpj-dpji))   
                        }
                        if(dpji != 0){
                            dp[i].add(dpj/dpji)
                        }
                        if(dpj != 0){
                            dp[i].add(dpji/dpj)
                        }
                    }
                }
            }
            if(dp[i].contains(number)){
                return i
            }
        }
        return -1
    }
}