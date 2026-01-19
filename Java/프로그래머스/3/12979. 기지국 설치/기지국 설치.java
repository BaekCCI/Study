class Solution {
    public int solution(int n, int[] stations, int w) {

        int afterLastInstalled = 1;
        int count = 0;

        for (int i = 0; i < stations.length; i++) {
            int l = stations[i] - w;
            int r = stations[i] + w;

            if (afterLastInstalled < l) {
                int range = l - afterLastInstalled;
                int installCount = range / (2 * w + 1);
                int remain = range % (2 * w + 1);

                if (remain == 0) {
                    count += installCount;
                } else {
                    count += installCount + 1;
                }
            }

            afterLastInstalled = r + 1;
        }

        if (afterLastInstalled <= n) { // Kotlin은 < n, Java는 <= n로 수정 가능
            int range = n - afterLastInstalled + 1;
            int installCount = range / (2 * w + 1);
            int remain = range % (2 * w + 1);

            if (remain == 0) {
                count += installCount;
            } else {
                count += installCount + 1;
            }
        }

        return count;
    }
}
