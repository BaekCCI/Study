import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long x = sc.nextLong(); // 총 횟수
        long y = sc.nextLong(); // 이긴 횟수

        long z = (long) ((y * 100.0) / x);

        long s = 1L;
        long e = 1_000_000_000L;
        long answer = -1L;

        while (s <= e) {
            long mid = (s + e) / 2;
            long newZ = (long) (((y + mid) * 100.0) / (x + mid));

            if (newZ <= z) {
                s = mid + 1;
            } else {
                answer = mid;
                e = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
