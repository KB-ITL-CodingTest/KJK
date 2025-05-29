import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int inc = 1;
        int dec = 1; 
        int max = 1; 

        for (int i = 1; i < N; i++) {
            if (arr[i] >= arr[i - 1]) {
                inc++;
            } else {
                inc = 1;
            }

            if (arr[i] <= arr[i - 1]) {
                dec++;
            } else {
                dec = 1;
            }

            max = Math.max(max, Math.max(inc, dec));
        }

        System.out.println(max);
    }
}
