import java.util.Scanner;

public class Main {
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int abs = Math.abs(n);
        int sign = 0;

        long[] dp = new long[abs + 2];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= abs; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        long result = dp[abs];

        if (n == 0) {
            sign = 0;
        } else if (n > 0) {
            sign = 1;
        } else {
            // F(-n) = (-1)^(n+1) * F(n)
            sign = (abs % 2 == 0) ? -1 : 1;
        }

        System.out.println(sign);
        System.out.println(result);
    }
}
