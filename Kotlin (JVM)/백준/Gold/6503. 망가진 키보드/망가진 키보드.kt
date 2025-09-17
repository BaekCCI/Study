fun main() {

    while (true) {
        val m = readln().toInt()
        if (m == 0) break
        val input = readln()
        
        var length = 0
        val count = mutableMapOf<Char, Int>()

        var l = 0
        var r = 0
        while (r < input.length) {
            val ch = input[r]
            count[ch] = count.getOrDefault(ch, 0) + 1

            while (count.size > m) {
                val lCh = input[l]
                count[lCh] = count[lCh]!! - 1
                if (count[lCh] == 0) count.remove(lCh)
                l++
            }
            length = maxOf(length, r - l + 1)
            r++
        }
        println(length)
    }
}