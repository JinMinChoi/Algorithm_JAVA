package backjoon.level.dp;


import java.util.Scanner;

public class Q1904 {
    private static final int MAX = 1_000_001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[MAX];

        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i < MAX; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        System.out.println(arr[n]);
    }
}
