import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i = 2; i <= n; i++) {
            if (i >= 2 && dp[i - 2] != 100001) {
                dp[i] = Math.min(dp[i], dp[i - 2] + 1);
            }
            if (i >= 5 && dp[i - 5] != 100001) {
                dp[i] = Math.min(dp[i], dp[i - 5] + 1);
            }
        }

        System.out.println(dp[n] == 100001 ? -1 : dp[n]);
    }
}
