import java.math.BigInteger

fun main() {

    val pick3Idx = arrayOf(
        intArrayOf(0, 1, 2), intArrayOf(0, 1, 3),
        intArrayOf(0, 2, 4), intArrayOf(0, 3, 4),
        intArrayOf(1, 2, 5), intArrayOf(1, 3, 5),
        intArrayOf(2, 4, 5), intArrayOf(3, 4, 5)
    )

    val n = readln().toLong()
    val dice = readln().split(" ").map { it.toLong() }

    if(n==1L){
        println(dice.sum() - dice.max())
        return
    }
    var min3 = Long.MAX_VALUE
    pick3Idx.forEach {
        min3 = minOf(min3, dice[it[0]] + dice[it[1]] + dice[it[2]])
    }

    var min2 = Long.MAX_VALUE
    for (i in dice.indices) {
        for (j in i + 1 until dice.size) {
            if (i + j == 5) continue
            min2 = minOf(min2, dice[i] + dice[j])
        }
    }
    val min1 = dice.min()


    val sum: BigInteger =
        BigInteger.valueOf(min3 * 4 + min2 * (8 * n - 12) + min1 * (5 * n * n - 16 * n + 12))
    println(sum)
}