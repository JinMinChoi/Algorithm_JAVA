package inflearnLecture.question.implementation;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum += i;
                if (i == n / 2) {
                    sb.append(i).append(" = ").append(sum);
                    break;
                }
                sb.append(i).append(" + ");
            }
        }

        System.out.println(sb);

    }
}
