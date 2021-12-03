package inflearnLecture.question.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (sum(a) == b) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static int sum(int a) {
        int temp = 0;
        for (int i = 1; i <= a; i++) {
            temp += i;
        }
        return temp;
    }
}
