package backjoon.level.math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while ((testCase--) > 0) {
            int num = Integer.parseInt(br.readLine());

            int small = num / 2;
            int big = num / 2;

            while (true) {
                if (isSosu(small) && isSosu(big)) break;

                small--;
                big++;
            }

            System.out.println(small + " " + big);
        }
    }

    private static boolean isSosu(int num) {
        if (num < 2) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
