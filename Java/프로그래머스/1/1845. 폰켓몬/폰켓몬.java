import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        
        for (int num : nums) {
            numbers.add(num);
        }
        
        return Math.min(nums.length / 2, numbers.size());
    }
}
