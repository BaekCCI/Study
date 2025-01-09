class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        val a : MutableList<Int> = mutableListOf()
        val b: MutableList<Int> = mutableListOf()

        val temp: MutableSet<Int> = mutableSetOf()
        for (i in topping.indices) {
            temp.add(topping[i])
            a.add(temp.size)
        }
        temp.clear()
        for(i in topping.size-1 downTo 0){
            temp.add(topping[i])
            b.add(temp.size)
        }
        b.reverse()
        for(i in 0..topping.size-2){
            if(a[i]==b[i+1]){
                answer++
            }
        }
        return answer
    }
}