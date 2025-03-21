class Solution {
    fun solution(citations: IntArray): Int {
        val sortedCitations = citations.sorted()
        val size = sortedCitations.size
        var h = minOf(size,sortedCitations.last())

        while(h >= 1){
            if(sortedCitations[size-h]>=h ){
                return h
            }
            h--
        }
        return 0
    }
}