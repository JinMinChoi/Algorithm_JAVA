package backjoon.level.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1003 {
    /**
     * i = n을 의미하고, j = 0(0의 카운트), j = 1(1의 카운트)를 의미한다.
     */
    private static int[][] arr = new int[42][2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        arr[0][0] = 1;
        arr[1][1] = 1;

        for (int i = 2; i < 41; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = arr[i - 1][j] + arr[i - 2][j];
            }
        }

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(arr[n][0] + " " + arr[n][1]);
        }
    }

}
