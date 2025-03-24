import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = (sc.nextInt()) % 24;
        int b = sc.nextInt();
        b += sc.nextInt();

        if (b >= 60) {
            a = (a + b / 60) % 24;
            b %= 60;
        }

        System.out.printf("%d %d", a, b);
    }
}