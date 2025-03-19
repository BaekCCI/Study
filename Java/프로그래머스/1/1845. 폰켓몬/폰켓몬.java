import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> pocket = new HashSet<>();

        for (int num : nums) {
            pocket.add(num);
        }

        return Math.min(nums.length / 2, pocket.size());
    }
}
