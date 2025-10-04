class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()


        val todayDays = today.toDays()
        val formattedTerms: Map<String, Int> = terms.associate {
            val (type, period) = it.split(" ")
            type to period.toInt()
        }


        privacies.forEachIndexed { index, privacy ->
            val (date, type) = privacy.split(" ")

            val expirationDay = date.toDays() + formattedTerms[type]!! * 28 - 1

            if (todayDays > expirationDay) {
                answer += index + 1
            }
        }

        return answer
    }

    fun String.toDays(): Int {
        val (y, m, d) = this.split(".").map { it.toInt() }
        return y * 12 * 28 + m * 28 + d

    }
}