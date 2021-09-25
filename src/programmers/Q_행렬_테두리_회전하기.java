package programmers;

public class Q_행렬_테두리_회전하기 {
    private static int[][] arr;
    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int min;

    public static void main(String[] args) {

        Q_행렬_테두리_회전하기 q = new Q_행렬_테두리_회전하기();

        int r = 6;
        int c = 6;
        int[][] queries = {
                {2, 2, 5, 4},
                {3, 3, 6, 6},
                {5, 1, 6, 3}
        };

        int[] s = q.solution(r, c, queries);
        for (int i : s) {
            System.out.print(i + " ");
        }
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        arr = new int[rows][columns];
        int value = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = value++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            min = Integer.MAX_VALUE;
            answer[i] = rotate(query);
        }

        return answer;
    }

    private int rotate(int[] query) {
        int sX = query[0] - 1;
        int sY = query[1] - 1;
        int eX = query[2] - 1;
        int eY = query[3] - 1;

        int temp = arr[sX][sY];
        int idx = 0;

        int curX = sX;
        int curY = sY;

        while (idx < 4) {
            int nextX = curX + dx[idx];
            int nextY = curY + dy[idx];

            if (nextX < sX || nextY < sY || nextX > eX || nextY > eY) {
                idx++;
            } else {
                arr[curX][curY] = arr[nextX][nextY];
                min = Math.min(min, arr[curX][curY]);
                curX = nextX;
                curY = nextY;
            }
            printArr();
        }

        arr[curX][curY + 1] = temp;

        min = Math.min(min, arr[curX][curY + 1]);

        return min;
    }
}
