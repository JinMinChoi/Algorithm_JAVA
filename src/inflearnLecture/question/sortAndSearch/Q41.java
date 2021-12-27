package inflearnLecture.question.sortAndSearch;

import java.util.Scanner;

public class Q41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int p1 = 0, p2 = 1;
        int answerCount = 0;
        while (p1 < n && p2 < n) {
            StringBuilder sb = new StringBuilder();
            int sum = 0;

            for (int i = p1; i <= p2; i++) {
                sum += arr[i];
                sb.append(arr[i]);
                if (i == p2) {
                    sb.append(" = ");
                    break;
                } else {
                    sb.append(" + ");
                }
            }

            if (sum < n) {
                p2++;
            } else if (sum == n) {
                sb.append(sum);
                System.out.println(sb);
                p1++;
                p2 = p1 + 1;
                answerCount++;
            } else {
                p1++;
                p2 = p1 + 1;
            }
        }
        System.out.println(answerCount);
    }
}
