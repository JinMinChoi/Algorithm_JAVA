package backjoon.level.bruteForce;

import java.util.Scanner;

public class Q1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int devil = 666;
        int cnt = 1;

        while (n != cnt) {
            devil++;
            if (String.valueOf(devil).contains("666")) {
                cnt++;
            }
        }

        System.out.println(devil);
    }
}
