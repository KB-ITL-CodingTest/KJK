import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int minBags = Integer.MAX_VALUE;

        for (int i = 0; i <= N / 3; i++) {
            int weightBy3 = 3 * i;
            int remaining = N - weightBy3;

            if (remaining % 5 == 0) {
                int j = remaining / 5;
                int totalBags = i + j;
                minBags = Math.min(minBags, totalBags);
            }
        }

        if (minBags == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minBags);
        }
    }
}
