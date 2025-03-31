fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val belt = readln().split(" ").map { it.toInt() }.toMutableList()
    var upIdx = 0
    var downIdx = n - 1

    var zeroCount = belt.count { it == 0 }
    val robots = ArrayDeque<Int>()

    var answer = 0
    while (zeroCount < k) {
        answer++
        //1번
        upIdx = (upIdx - 1 + 2 * n) % (2 * n)
        downIdx = (downIdx - 1 + 2 * n) % (2 * n)

        //로봇 확인
        val robotNum = robots.size
        for (i in 0 until robotNum) {
            val robot = robots.removeFirst()
            if (robot != downIdx) {
                robots.addLast(robot)
            }
        }
        //2번
        val robotN = robots.size
        for (i in 0 until robotN) {
            val robot = robots.removeFirst()
            //다음 위치에 로봇이 있거나, 다음 칸 내구도가 1보다 작으면(즉 0이면)
            if (robots.contains((robot + 1) % (2 * n)) || belt[(robot + 1) % (2 * n)] < 1) {
                //이동하지 않고 그대로 있음
                robots.addLast(robot)
                // 다음 위치에 로봇이 없고, 내구도가 1 이상이면
            } else {
                //다음 위치가 내리는 위치가 아니면
                if ((robot + 1) % (2 * n) != downIdx) {
                    //한칸 이동
                    robots.addLast((robot + 1) % (2 * n))
                }
                //해당 칸 내구도 감소
                belt[(robot + 1) % (2 * n)]--
                if (belt[(robot + 1) % (2 * n)] == 0) {
                    zeroCount++
                }
            }
        }
        //3번
        //올리는 위치의 내구도가 0이 아니라면
        if (belt[upIdx] != 0) {
            // 로봇을 올리고 내구도 감소
            robots.addLast(upIdx)
            belt[upIdx]--
            //내구도가 0이라면 zerocount++
            if (belt[upIdx] == 0) {
                zeroCount++
            }
        }
    }
    println(answer)
}