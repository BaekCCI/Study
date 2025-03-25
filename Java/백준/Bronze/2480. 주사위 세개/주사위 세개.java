import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Integer> count = new HashMap<>();
        for (int i=0; i<3; i++) {
            int input = sc.nextInt();
            count.put(input, count.getOrDefault(input, 0) + 1);
        }
        int result;

        if (count.size() == 1) {
            int value = count.keySet().iterator().next();
            result = 10000 + 1000 * value;
        } else if (count.size() == 2) {
            int value = 0;
            for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
                if (entry.getValue() == 2) {
                    value = entry.getKey();
                    break;
                }
            }
            result = 1000 + 100 * value;
        } else {
            int value = Collections.max(count.keySet());
            result = value * 100;
        }
        System.out.println(result);
    }
}