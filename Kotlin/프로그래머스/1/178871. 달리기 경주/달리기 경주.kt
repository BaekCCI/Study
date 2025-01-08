class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        val rank = players.mapIndexed { index, name -> name to index }.toMap().toMutableMap() //이름, 순위
        callings.forEach {
            val index = rank.getOrDefault(it,0)
            val temp = players[index-1]

            players[index-1]=it
            players[index]=temp
            rank[it] = index-1
            rank[temp] = index
        }
        return players
    }
}