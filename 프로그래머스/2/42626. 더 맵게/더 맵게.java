import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int k) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }

        while (pq.peek() < k) {
            if (pq.size() < 2) {
                return -1;
            }

            pq.offer(pq.poll() + (pq.poll() * 2));
            answer++;
        }

        return answer;
    }
}