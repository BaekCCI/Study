fun main() {
    val (l, c) = readln().split(" ").map { it.toInt() }
    val characters = readln().split(" ").map { it[0] }.sorted()

    val vowel = listOf('a', 'i', 'o', 'u', 'e')
    fun combination(index: Int, result: List<Char>) {
        if (result.size == l) {
            val countVowel = result.count { it in vowel }
            if (countVowel > 0 && l - countVowel > 1) {
                println(result.joinToString(""))
            }
            return
        }
        for (i in index until c) {
            combination(i + 1, result + characters[i])
        }
    }
    combination(0, emptyList())
}