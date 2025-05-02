fun main() {
    val n = readln().toInt()
    val eggs = Array(n) { IntArray(2) }
    for (i in 0 until n) {
        eggs[i] = readln().split(" ").map { it.toInt() }.toIntArray()
    }

    var sum = 0
    fun breakEggs(curEgg: Int, breakCnt: Int) {
        if (curEgg == n) {
            sum = maxOf(sum, breakCnt)
            return
        }
        var hit = false
        for (i in 0 until n) {
            //자기 자신을 깰 수 없음
            if (i == curEgg) continue
            //깨진 계란이면
            else if (eggs[i][0] <= 0) continue
            //현재 계란이 깨진 경우
            else if (eggs[curEgg][0] <= 0) {
                breakEggs(curEgg + 1, breakCnt)
            }
            //깨뜨린 경우
            else {
                hit = true
                eggs[i][0] -= eggs[curEgg][1]
                eggs[curEgg][0] -= eggs[i][1]
                var tempCnt = 0
                if (eggs[i][0] <= 0) {
                    tempCnt++
                }
                if (eggs[curEgg][0] <= 0) {
                    tempCnt++
                }
                breakEggs(curEgg + 1, breakCnt + tempCnt)
                eggs[i][0] += eggs[curEgg][1]
                eggs[curEgg][0] += eggs[i][1]
            }
        }
        //아무것도 못 깬 경우
        if(!hit){
            breakEggs(curEgg+1,breakCnt)
        }
    }
    breakEggs(0, 0)

    println(sum)
}