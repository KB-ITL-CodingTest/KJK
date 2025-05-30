import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); 

        int[] dp = new int[11]; 
        dp[0] = 1; 
        dp[1] = 1; 
        dp[2] = 2; 
        dp[3] = 4; 

        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        while (T-- > 0) {
            int n = sc.nextInt();
            System.out.println(dp[n]);
        }

        sc.close();
    }
}
