package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10881 {
    private static int[] row;
    private static int[] col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while ((tc--) > 0) {
            row = new int[6];
            col = new int[6];

            for (int i = 0; i < 3; i++) {
                String[] s = br.readLine().split(" ");

                row[i] = col[i + 3] = Integer.parseInt(s[0]);
                row[i + 3] = col[i] = Integer.parseInt(s[1]);
            }

            System.out.println(perform());
        }
    }

    private static int perform() {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (i % 3 == j % 3 || j % 3 == k % 3 || k % 3 == i % 3) { //같은 박스 제외
                        continue;
                    }

                    // 1. 상자가 일렬
                    int w = row[i] + row[j] + row[k];
                    int h = Math.max(Math.max(col[i], col[j]), col[k]);
                    ans = Math.min(ans, w * h);

                    // 2. 상자가 위아래 (2개 1개) -> 1개 2개일 때도 같은 경우이기 때문에 굳이 탐색할 필요가 없다.
                    w = Math.max(row[i] + row[j], row[k]);
                    h = Math.max(col[i], col[j]) + col[k];
                    ans = Math.min(ans, w * h);
                }
            }
        }

        return ans;
    }
}
