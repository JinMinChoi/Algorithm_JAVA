package level.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        System.out.println(sol(input));
    }

    private static int sol(int num) {
        int left = 2, right = 1;

        if (num == right) {
            return right;
        }

        int n = 1;
        while (true) {
            right += n * 6;

            if (left <= num && right >= num) break;

            left += n * 6;

            n++;
        }

        return n + 1;
    }
}
