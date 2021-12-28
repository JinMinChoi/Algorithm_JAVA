package inflearnLecture.question.sortAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q47 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 2][n + 2];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (check(arr, i, j)) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    private static boolean check(int[][] arr, int i, int j) {
        if(arr[i][j] <= arr[i-1][j]) return false;
        if(arr[i][j] <= arr[i][j+1]) return false;
        if(arr[i][j] <= arr[i+1][j]) return false;
        if(arr[i][j] <= arr[i][j-1]) return false;
        return true;
    }
}
