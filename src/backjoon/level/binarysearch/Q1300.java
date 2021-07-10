package backjoon.level.binarysearch;

import java.util.Scanner;

public class Q1300 {
    private static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        int left = 1;
        int right = k;

        int ans = 0;

        while (left <= right) {
            int mid = (left + right) / 2; //인덱스에 해당하는 값

            int index = 0; //인덱스

            for (int i = 1; i <= n; i++) {
                index += Math.min(mid / i, n);
            }

            if (index < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
                ans = mid;
            }
        }

        System.out.println(ans);
    }
}
