import java.util.*


val difDirection = arrayOf(
    intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0)
)

enum class Status(val char: Char, val sameDirection: Array<IntArray>) {
    RightUp('/', arrayOf(intArrayOf(-1, 1), intArrayOf(1, -1))),
    RightDown('\\', arrayOf(intArrayOf(-1, -1), intArrayOf(1, 1)));

    fun change(): Status {
        return if (this == RightUp) RightDown else RightUp
    }

    companion object {
        fun getStatus(char: Char): Status {
            return entries.find { it.char == char }!!
        }
    }
}

data class PointStatus(
    val point: Pair<Int, Int>,
    val status: Status,
)

fun main() {

    val (N, M) = readln().split(" ").map { it.toInt() }
    val map = Array(N) { Array(M) { Status.RightUp } }

    repeat(N) { i ->
        map[i] = readln().map { Status.getStatus(it) }.toTypedArray()
    }

    val arr: MutableMap<Status, Array<IntArray>> = mutableMapOf(
        Status.RightDown to Array(N) { IntArray(M) { Int.MAX_VALUE } },
        Status.RightUp to Array(N) { IntArray(M) { Int.MAX_VALUE } },
    )


    val pq = PriorityQueue<Pair<PointStatus, Int>>(compareBy { it.second })

    if(map[0][0] == Status.RightDown){
        arr[Status.RightDown]!![0][0] = 0
        pq.add(PointStatus(point = 0 to 0, status = Status.RightDown) to 0)
    }else{
        arr[Status.RightDown]!![0][0] = 1
        pq.add(PointStatus(point = 0 to 0, status = Status.RightDown) to 1)
    }

    while (pq.isNotEmpty()) {
        val (pointStatus, count) = pq.poll()

        val (r, c) = pointStatus.point
        val status = pointStatus.status


        for ((dr, dc) in status.sameDirection) {
            val nr = r + dr
            val nc = c + dc

            if (nr !in 0 until N || nc !in 0 until M) continue
            val toChange = map[nr][nc] != status
            var nCount = count

            if (toChange) nCount++

            if (arr[status]!![nr][nc] <= nCount) continue

            arr[status]!![nr][nc] = nCount
            pq.add(PointStatus(point = nr to nc, status = status) to nCount)
        }
        for ((dr, dc) in difDirection) {
            val nr = r + dr
            val nc = c + dc

            if (nr !in 0 until N || nc !in 0 until M) continue

            val toChange = map[nr][nc] == status
            var nCount = count
            if (toChange) nCount++

            val nStatus = status.change()

            if (arr[nStatus]!![nr][nc] <= nCount) continue

            arr[nStatus]!![nr][nc] = nCount
            pq.add(PointStatus(point = nr to nc, status = nStatus) to nCount)
        }
    }

    val answer = arr[Status.RightDown]!![N - 1][M - 1]
    println(if (answer == Int.MAX_VALUE) "NO SOLUTION" else answer)
}
