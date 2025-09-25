class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {

        val scores: MutableMap<Char, Int> = mutableMapOf(
            'R' to 0, 'T' to 0,
            'C' to 0, 'F' to 0,
            'J' to 0, 'M' to 0,
            'A' to 0, 'N' to 0
        )

        for (i in choices.indices) {
            val (a, b) = survey[i].toCharArray()
            val choice = choices[i]

            if (choice < 4) {
                scores[a] = scores[a]!! + (4 - choice)
            } else if (choice > 4) {
                scores[b] = scores[b]!! + choice - 4
            }
        }

        var result = ""
        for (i in 0 until 8 step 2) {
            val a = scores.entries.elementAt(i)
            val b = scores.entries.elementAt(i + 1)

            result +=
                if (a.value > b.value) a.key
                else if (a.value < b.value) b.key
                else a.key
        }
        return result
    }
}