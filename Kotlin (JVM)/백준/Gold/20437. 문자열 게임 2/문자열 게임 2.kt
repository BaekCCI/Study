fun main() {
    val t = readln().toInt()

    fun getLength(w: String, k: Int) {
        val storeIdx = mutableMapOf<Char, MutableList<Int>>()

        for (i in w.indices) {
            storeIdx.getOrPut(w[i]) { mutableListOf() }.add(i)
        }
        var shortest = Int.MAX_VALUE
        var longest = Int.MIN_VALUE

        for (charIndex in storeIdx) {
            val (ch, idxs) = charIndex
            if (idxs.size < k) {
                continue
            }
            var l = 0
            var r = l + k - 1
            while (r < idxs.size) {
                shortest = minOf(idxs[r] - idxs[l] + 1, shortest)
                longest = maxOf(idxs[r] - idxs[l] + 1, longest)
                r++
                l++
            }
        }
        if(shortest == Int.MAX_VALUE){
            println(-1)
        }else{
            println("$shortest $longest")
        }
    }

    for (i in 0 until t) {
        val w = readln()
        val k = readln().toInt()
        getLength(w, k)
    }
}