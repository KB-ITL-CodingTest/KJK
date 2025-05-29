import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();

        int[] dp = new int[N + 1];
        final int INF = 1_000_000_000;
        for (int i = 1; i <= N; i++) dp[i] = INF;

        dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            for (int len = 1; len <= 3; len++) {
                if (i - len < 0) continue;
                String sub = s.substring(i - len, i);

                if (isValid(sub)) {
                    dp[i] = Math.min(dp[i], dp[i - len] + 1);
                }
            }
        }

        System.out.println(dp[N]);
    }

    static boolean isValid(String part) {
        if (part.length() > 1 && part.charAt(0) == '0') return false;
        int num = Integer.parseInt(part);
        return num <= 641;
    }
}
