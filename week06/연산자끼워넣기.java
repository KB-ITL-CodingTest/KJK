import java.util.Scanner;

public class Main {
    static int N;
    static int[] numbers;
    static int[] operators; // +, -, *, /
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        operators = new int[4];
        for (int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        dfs(numbers[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

 
    static void dfs(int current, int idx) {
        if (idx == N) {
            max = Math.max(max, current);
            min = Math.min(min, current);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                int next = 0;
                switch (i) {
                    case 0: next = current + numbers[idx]; break;
                    case 1: next = current - numbers[idx]; break;
                    case 2: next = current * numbers[idx]; break;
                    case 3: next = current / numbers[idx]; break;
                }

                dfs(next, idx + 1);
                operators[i]++;
            }
        }
    }
}
