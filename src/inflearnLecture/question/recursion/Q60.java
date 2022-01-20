package inflearnLecture.question.recursion;

import java.util.Scanner;

public class Q60 {
    private static int n;
    private static int total = 0;
    private static boolean flag = false;
    private static String answer = "NO";
    private static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total += arr[i];
        }

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int depth, int sum) {
        if (flag) return;
        if (sum > total / 2) return;
        if (depth == n) {
            if (total - sum == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            dfs(depth + 1, sum + arr[depth]);
            dfs(depth + 1, sum);
        }
    }
}
