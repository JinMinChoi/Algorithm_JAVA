package inflearnLecture.question;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        int sum = 0;
        for (int i = a; i < b; i++) {
            sb.append(i).append(" + ");
            sum += i;
        }
        sum += b;
        sb.append(b).append(" = ").append(sum);

        System.out.println(sb);
    }
}
