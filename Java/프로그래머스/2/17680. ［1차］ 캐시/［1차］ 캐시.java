import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        
        List<String> cache = new LinkedList<>();

        for (String city : cities) {
            String lowerCity = city.toLowerCase();
            
            if (cache.contains(lowerCity)) {
                answer += 1;
                cache.remove(lowerCity);
            } else {
                answer += 5;
                if (cache.size() == cacheSize) {
                    if (!cache.isEmpty()) {
                        cache.remove(0);
                    }
                }
            }
            cache.add(lowerCity);
        }

        return answer;
    }
}
