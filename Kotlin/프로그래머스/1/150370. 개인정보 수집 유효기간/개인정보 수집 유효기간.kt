class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        
        val todayValue = today.toValue()
        
        val term : Map<String,Int> = terms.associate{
            val (type, period) = it.split(" ")
            type to period.toInt()
        }
        
        for(i in privacies.indices){
            val (date, type) = privacies[i].split(" ")
            val dateValue = date.toValue()
            
            val periodValue = term[type]!!*28-1
            if(dateValue+periodValue<todayValue){
                answer+=i+1
            }
        }
        return answer
    }
    
    fun String.toValue():Int{
        val (y,m,d) = this.split(".").map{it.toInt()}
        return y*12*28 + m*28 + d
    }
}