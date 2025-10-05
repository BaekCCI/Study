class Solution {
    fun solution(coin: Int, cards: IntArray): Int {
        val n = cards.size

        val myCards = mutableListOf<Int>()
        for (i in 0 until n / 3) {
            myCards.add(i)
        }

        val newCards = mutableListOf<Int>()

        var round = 1
        var remainCoin = coin

        fun findCombi(card: List<Int>): IntArray? {
            for (i in card.indices) {
                val a = cards[card[i]]
                for (j in i + 1 until card.size) {
                    if (a + cards[card[j]] == n + 1) {
                        return intArrayOf(j, i)
                    }
                }
            }
            return null
        }

        fun findCombiWith(mine: List<Int>, get: List<Int>): IntArray? {
            for (i in mine.indices) {
                val a = cards[mine[i]]
                for (j in get.indices) {
                    val b = cards[get[j]]
                    if (a + b == n + 1) {
                        return intArrayOf(i, j)

                    }
                }
            }
            return null
        }
        for (r in n / 3 until n step 2) {

            newCards.add(r)
            newCards.add(r + 1)

            val resultMine = findCombi(myCards)
            if (resultMine != null) {
                resultMine.forEach {
                    myCards.removeAt(it)
                }
                round++
                continue
            }

            if(remainCoin>=1){
                val combiResult = findCombiWith(myCards, newCards)
                if (combiResult != null) {
                    myCards.removeAt(combiResult[0])
                    newCards.removeAt(combiResult[1])
                    remainCoin--
                    round++
                    continue
                }
            }
            if(remainCoin>=2){
                val newResult = findCombi(newCards) ?: break
                newResult.forEach {
                    newCards.removeAt(it)
                }
                remainCoin-=2
                round++
                continue
            }
            break
        }

        return round
    }
}