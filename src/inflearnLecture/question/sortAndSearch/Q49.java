package inflearnLecture.question.sortAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q49 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[0][i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][0] > arr[0][j]) {
                    arr[i][j] = arr[0][j];
                } else {
                    arr[i][j] = arr[i][0];
                }
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
}
