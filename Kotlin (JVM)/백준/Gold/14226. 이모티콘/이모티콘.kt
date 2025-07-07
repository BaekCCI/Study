fun main() {

    val s = readln().toInt()
    val que = ArrayDeque<IntArray>()
    val visit = Array(2001) { BooleanArray(2001) }
    //스크린 개수, 클립 개수
    que.add(intArrayOf(1, 0))
    visit[1][0] = true

    var count = 0
    while (que.isNotEmpty()) {
        val size = que.size

        for (i in 0 until size) {
            var (screen, clip) = que.removeFirst()

            if (screen == s) {
                println(count)
                return
            }
            if (!visit[screen][screen]) {
                que.add(intArrayOf(screen, screen))
                visit[screen][screen] = true
            }
            if (clip != 0 && screen + clip < 2001 && !visit[screen + clip][clip]) {
                que.add(intArrayOf(screen + clip, clip))
                visit[screen + clip][clip] = true
            }
            if (screen > 1 && !visit[screen - 1][clip]) {
                que.add(intArrayOf(screen - 1, clip))
                visit[screen - 1][clip] = true
            }
        }
        count++
    }
}