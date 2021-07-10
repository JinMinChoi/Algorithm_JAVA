package level.dp;

import java.io.*;
import java.util.StringTokenizer;

public class Q10942 {
    private static int n;
    private static int[] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        createDP();
        int m = Integer.parseInt(br.readLine());
        while ((m--) > 0) {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(dp[s][e]).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void createDP() {
        //dp[s][e] : s~e까지 팰린드롬인지

        //1) 자기자신은 무조건 팰린드롬(1개 연속)
        for (int i = 1; i <= n; i++) {
            dp[i][i] = 1;
        }

        //2) 연속된 두 수가 같으면 팰린드롬
        for (int i = 1; i <= n - 1; i++) {
            if (arr[i] == arr[i + 1]) dp[i][i + 1] = 1;
        }

        //3) (중요) 연속된 3개 이상의 수 팰린드롬 조건 => (시작+1) ~ (끝-1) 펠린드롬 and 시작==끝
        for (int i = 2; i < n; i++) { // i는 간격
            for (int j = 1; j <= n - i; j++) { //j는 현재 인덱스
                if ((dp[j + 1][j + i - 1] == 1) && (arr[j] == arr[j + i])) {
                    dp[j][j + i] = 1;
                }
            }
        }
    }
}
