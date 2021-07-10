package level.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while ((testCase--) > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());
            System.out.println(sol(a, b));
        }
    }

    private static int sol(long x, long y) {
        int answer = 2;

        long start = x + 1;
        long end = y - 1;

        int plusValue = answer;

        if (y - x == 1) {
            answer = 1;
        } else if (y - x == 2) {
            answer = 2;
        } else {
            while (start < end) {
                start += plusValue++;
                answer++;
            }
        }

        return answer;
    }
}
