package inflearnLecture.question.recursion;

import java.util.Scanner;

public class Q61 {
    private static int n, m;
    private static int[] arr;
    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        dfs(0, 0);

        if (count == 0) System.out.println(-1);
        else System.out.println(count);
    }

    private static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == m) {
                count++;
            }
        } else {
            dfs(depth + 1, sum + arr[depth]);
            dfs(depth + 1, sum - arr[depth]);
            dfs(depth + 1, sum);
        }
    }
}
