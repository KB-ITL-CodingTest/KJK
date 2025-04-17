import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(countConsecutiveSum(N));
    }

    public static int countConsecutiveSum(int N) {
        int count = 0;
        int start = 1, end = 1, sum = 1;

        while (start <= N) {
            if (sum < N) {
                end++;
                sum += end;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else {
                count++;
                sum -= start;
                start++;
            }
        }

        return count;
    }
}
