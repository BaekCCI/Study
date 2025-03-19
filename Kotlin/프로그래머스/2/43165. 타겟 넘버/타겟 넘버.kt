class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        
        fun dfs(depth: Int = 0, result: Int = 0){
            if(depth == numbers.size){
                if(result == target){
                    answer ++
                }
            }else{
                dfs(depth+1,result+numbers[depth])
                dfs(depth+1,result-numbers[depth])
            }
            
        }
        dfs()
        return answer
    }
}