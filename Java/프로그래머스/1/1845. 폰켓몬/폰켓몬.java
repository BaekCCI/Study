import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        answer = Math.min(nums.length / 2, count.size());
        return answer;
    }
}
