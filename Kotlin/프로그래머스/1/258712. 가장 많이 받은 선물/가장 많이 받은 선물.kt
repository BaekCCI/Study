class Solution {
    data class Gift(
        val from: String,
        val count: MutableMap<String, Int> = mutableMapOf(),
        var total: Int = 0
    )

    fun solution(friends: Array<String>, gifts: Array<String>): Int {

        val list = mutableListOf<Gift>()
        val result = mutableMapOf<String, Int>()

        friends.forEach { f ->
            val count = friends.filter { it != f }.associateWith { 0 }
            list.add(Gift(from = f, count = count.toMutableMap()))
            result[f] = 0
        }

        gifts.forEach {
            val (from, to) = it.split(" ")
            list.find { it.from == from }?.let { gift ->
                gift.count[to] = (gift.count[to] ?: 0) + 1
                gift.total++
            }
            list.find { it.from == to }?.let { gift ->
                gift.total--
            }
        }

        for (i in friends.indices) {
            val a = list[i]
            for (j in i until friends.size) {
                val b = list[j]

                val aCount = a.count[b.from] ?: 0
                val bCount = b.count[a.from] ?: 0

                if ((aCount == 0 && bCount == 0) || aCount == bCount) {
                    if (a.total > b.total) { //선물지수가 더 큰 사람이 result++
                        result[a.from] = (result[a.from] ?: 0) + 1
                    } else if (a.total < b.total) {
                        result[b.from] = (result[b.from] ?: 0) + 1
                    }
                } else if (aCount != 0 || bCount != 0) {
                    //선물 준 횟수가 더 많은 사람이 result++
                    if (aCount > bCount) {
                        result[a.from] = (result[a.from] ?: 0) + 1
                    } else if (aCount < bCount) {
                        result[b.from] = (result[b.from] ?: 0) + 1
                    }
                }

            }
        }
        
        return (result.values.maxOrNull() ?: 0)
    }
}
