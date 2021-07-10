package backjoon.level.math;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2775 {
    private static int[][] apartment = new int[15][15];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 14; i++) {
            apartment[i][1] = 1;
            apartment[0][i] = i;
        }

        for (int i = 1; i <= 14; i++) {
            for (int j = 2; j <= 14; j++) {
                apartment[i][j] = apartment[i - 1][j] + apartment[i][j - 1];
            }
        }

        while ((testCase--) > 0) {
            int a = Integer.parseInt(br.readLine());
            int b = Integer.parseInt(br.readLine());
            System.out.println(apartment[a][b]);
        }
    }
}
