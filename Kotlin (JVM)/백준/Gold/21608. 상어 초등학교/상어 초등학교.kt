fun main() {
    val direction = arrayOf(intArrayOf(-1, 0), intArrayOf(1, 0), intArrayOf(0, -1), intArrayOf(0, 1))

    val n = readln().toInt()

    val students = LinkedHashMap<Int, IntArray>()

    repeat(n * n) {
        val input = readln().split(" ").map { it.toInt() }.toMutableList()
        val s = input.removeFirst()
        students[s] = input.toIntArray()
    }

    val map = Array(n) { IntArray(n) }
    map[1][1] = students.keys.first()

    for (i in 1 until n * n) {
        val (s, like) = students.entries.elementAt(i)

        var targetC = -1
        var targetR = -1

        var likeCount = -1
        var emptyCount = -1

        for (c in 0 until n) {
            for (r in 0 until n) {
                if (map[c][r] != 0) continue

                var tempLike = 0
                var tempEmpty = 0
                for (dir in direction) {
                    val nc = c + dir[0]
                    val nr = r + dir[1]
                    if (nc in 0 until n && nr in 0 until n) {

                        val cur = map[nc][nr]
                        if (cur == 0) tempEmpty++
                        else if (like.contains(cur)) tempLike++
                    }
                }

                if (tempLike > likeCount) {
                    targetC = c
                    targetR = r
                    likeCount = tempLike
                    emptyCount = tempEmpty
                } else if (tempLike == likeCount && tempEmpty > emptyCount) {
                    targetC = c
                    targetR = r
                    likeCount = tempLike
                    emptyCount = tempEmpty
                } else if (tempLike == likeCount && tempEmpty == emptyCount && (targetC == -1 || c < targetC || (c == targetC && r < targetR))) {
                    targetC = c
                    targetR = r
                    likeCount = tempLike
                    emptyCount = tempEmpty
                }
            }
        }
        map[targetC][targetR] = s
    }

    val score = intArrayOf(0, 1, 10, 100, 1000)
    var result = 0

    for (c in 0 until n) {
        for (r in 0 until n) {
            val s = map[c][r]
            val like = students[s]!!

            var count = 0
            for (dir in direction) {
                val nc = c + dir[0]
                val nr = r + dir[1]
                if (nc in 0 until n && nr in 0 until n) {
                    val cur = map[nc][nr]
                    if (like.contains(cur)) count++
                }
            }
            result += score[count]
        }
    }
    println(result)
}
