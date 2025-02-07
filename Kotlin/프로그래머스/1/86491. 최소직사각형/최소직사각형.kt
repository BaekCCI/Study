class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        var a = 0
        var b = 0
        sizes.forEach{
            it.sort()
            a = maxOf(a,it[0])
            b = maxOf(b,it[1])
        }
        answer = a*b
        
        return answer
    }
}