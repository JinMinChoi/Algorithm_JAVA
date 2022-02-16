package backjoon.implementation;

import java.util.Scanner;

public class Q2877 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        String[] binary = makeBinary(k + 1).split("");
        StringBuilder ans = new StringBuilder();

        for (String s : binary) {
            if (s.equals("0")) {
                ans.append("4");
            } else if (s.equals("1")) {
                ans.append("7");
            }
        }

        System.out.println(ans);
    }

    private static String makeBinary(int k) {
        StringBuilder sb = new StringBuilder();

        while (k != 0) {
            int r = k % 2;
            sb.append(r);
            k /= 2;
        }

        sb.reverse();
        sb.delete(0, 1);
        return sb.toString();
    }
}
