//https://programmers.co.kr/learn/courses/30/lessons/72413
package programmers;

public class Q_합승_택시_요금 {
    public static void main(String[] args) {
        Q_합승_택시_요금 q = new Q_합승_택시_요금();

        int[][] f = {
                {4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}
        };

        System.out.println(q.solution(6, 4, 6, 2, f));
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        int[][] node = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                node[i][j] = 200 * 100_000 + 1;
            }
            node[i][i] = 0;
        }

        for (int i = 0; i < fares.length; i++) {
            int f1 = fares[i][0];
            int f2 = fares[i][1];

            node[f1][f2] = node[f2][f1] = fares[i][2];
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    node[i][j] = Math.min(node[i][j], node[i][k] + node[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, node[s][i] + node[i][a] + node[i][b]);
        }
        return answer = min;
    }
}
