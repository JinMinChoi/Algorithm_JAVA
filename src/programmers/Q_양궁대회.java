package programmers;

public class Q_양궁대회 {
    private static int[] ret = {-1};
    private static int[] lion;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Q_양궁대회 q = new Q_양궁대회();
        int[] ans = q.solution(10, new int[]{0,0,0,0,0,0,0,0,3,4,3});
        for (int an : ans) {
            System.out.print(an + " ");
        }
    }

    public int[] solution(int n, int[] info) {
        lion = new int[11];
        dfs(info, 0, n);
        return ret;
    }

    private void dfs(int[] info, int depth, int n) {
        if (depth == n) {
            int apeachPoint = 0;
            int lionPoint = 0;

            for (int i = 0; i <= 10; i++) {
                if (info[i] != 0 || lion[i] != 0) {
                    if (lion[i] > info[i]) {
                        lionPoint += 10 - i;
                    } else {
                        apeachPoint += 10 - i;
                    }
                }
            }

            if (lionPoint > apeachPoint) {
                if (lionPoint - apeachPoint >= max) {
                    max = lionPoint - apeachPoint;
                    ret = lion.clone();
                }
            }
            return;
        }

        for (int i = 0; i <= 10 && lion[i] <= info[i]; i++) {
            lion[i]++;
            dfs(info, depth + 1, n);
            lion[i]--;
        }
    }
}
