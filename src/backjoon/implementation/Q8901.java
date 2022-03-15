package backjoon.implementation;

import java.io.IOException;
import java.util.Scanner;

public class Q8901 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while ((tc--) > 0) {
            int a, b, c, ab, bc, ca;
            int ans = 0;

            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            ab = sc.nextInt();
            bc = sc.nextInt();
            ca = sc.nextInt();

            for (int i = 0; i <= Math.min(a, b); i++) {
                for (int j = 0; j <= Math.min(b - i, c); j++) {
                    int k = Math.min(a - i, c - j);
                    ans = Math.max(ans, (ab * i) + (bc * j) + (ca * k));
                }
            }

            System.out.println(ans);
        }
    }
}
