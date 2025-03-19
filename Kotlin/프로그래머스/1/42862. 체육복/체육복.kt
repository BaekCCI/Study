class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        val sortReserve = reserve.filter{it !in lost}.sorted()
        val noClothes = lost.filter{it !in reserve}.toMutableList()
        answer += n - noClothes.size
        for(p in sortReserve){
            if(noClothes.contains(p-1)){
                answer++
                noClothes.remove(p-1)
            } else if(noClothes.contains(p+1)){
                answer++
                noClothes.remove(p+1)
                continue
            }
            if(noClothes.size == 0){
                break
            }
        }
        return answer
    }
}