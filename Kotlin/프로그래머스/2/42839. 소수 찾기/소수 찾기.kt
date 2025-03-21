import kotlin.math.*

class Solution {
    fun solution(numbers: String): Int {
        val primes = mutableSetOf<Int>()
        
        fun isPrime(num: Int):Boolean{
            if(num<2) return false
            for(i in 2 .. sqrt(num.toDouble()).toInt()){
                if(num%i==0){
                    return false
                }
            }
            return true
        }
        val visit = BooleanArray(numbers.length)
        fun generate(cur: String = ""){
            if(cur!=""){
                val num = cur.toInt()
                if(isPrime(num)){
                    primes.add(num)
                }
            }
            for(i in numbers.indices){
                if(!visit[i]){
                    visit[i] = true
                    generate(cur+numbers[i])
                    visit[i] = false
                }
            }
        }
        generate()
        return primes.size
    }
}