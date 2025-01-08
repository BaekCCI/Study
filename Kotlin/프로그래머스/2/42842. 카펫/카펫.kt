class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        var x = 0
        var y = 0

        for (i in 1..brown + yellow) {
            if ((brown + yellow).toDouble()%i == 0.0) {
                x = (brown + yellow)/i
                y = i
            }
            if((x-2)*(y-2)==yellow) {
                answer += intArrayOf(x,y)
                break
            }
        }
        println(answer.joinToString ())
        return answer
    }
}