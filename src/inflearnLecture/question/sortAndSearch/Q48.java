package inflearnLecture.question.sortAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q48 {
    private static final int SIZE = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < SIZE; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < SIZE; i++) {
            int sum = 0;
            double avr;
            int ans = 0;
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < SIZE; j++) {
                sum += arr[i][j];
            }
            avr = Math.round((double) sum / SIZE);

            for (int j = 0; j < SIZE; j++) {
                int sub = (int) Math.abs(avr - arr[i][j]);
                if (min > sub) {
                    min = sub;
                    ans = arr[i][j];
                }
            }

            System.out.println((int) avr + " " + ans);
        }
    }
}
