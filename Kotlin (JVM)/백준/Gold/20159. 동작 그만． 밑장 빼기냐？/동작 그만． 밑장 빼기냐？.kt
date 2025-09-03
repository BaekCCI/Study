fun main() {
    val n = readln().toInt()
    val cards = readln().split(" ").map { it.toInt() }

    val underCard = cards.last()

    val evenCards = IntArray(n + 1)
    val oddCards = IntArray(n + 1)

    for (i in 0 until n) {
        evenCards[i + 1] = evenCards[i]
        oddCards[i + 1] = oddCards[i]
        if (i % 2 == 0) {
            evenCards[i + 1] += cards[i]
        } else {
            oddCards[i + 1] += cards[i]
        }
    }
    var answer = evenCards[n]

    for (i in 0 until n) {
        if (i % 2 == 0) {
            val sum = evenCards[i] + (oddCards[n] - oddCards[i])
            answer = maxOf(answer, sum)
        } else {
            val sum = evenCards[i] + cards[i] + (oddCards[n] - oddCards[i + 1])-underCard
            answer = maxOf(answer, sum)
        }
    }
    println(answer)
}