class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        var w = 0
        var h = 0
        
        sizes.forEach{
            it.sort()
            w = maxOf(w,it[0])
            h = maxOf(h,it[1])
        }
        return w*h
    }
}