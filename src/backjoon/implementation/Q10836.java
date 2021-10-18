package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q10836 {
    private static int m, n, map[][];
    private static List<Integer> levelUpCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int zeroCount = Integer.parseInt(st.nextToken());
            int oneCount = Integer.parseInt(st.nextToken());
            int twoCount = Integer.parseInt(st.nextToken());

            levelUpCount = makeLevelUpList(zeroCount, oneCount, twoCount);
            first(levelUpCount);
            dp();
        }

        printMap();
    }

    private static void printMap() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dp() {
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < m; j++) {
                map[i][j] = Math.max(Math.max(map[i][j - 1], map[i - 1][j]), map[i - 1][j - 1]);
            }
        }
    }

    private static void first(List<Integer> levelUpCount) {
        for (int i = m - 1; i >= 0; --i) {
            map[i][0] = map[i][0] + levelUpCount.remove(0);
        }

        for (int i = 1; i < m; i++) {
            map[0][i] = map[0][i] + levelUpCount.remove(0);
        }
    }

    private static List<Integer> makeLevelUpList(int zeroCount, int oneCount, int twoCount) {
        List<Integer> temp = new ArrayList<>();

        while ((zeroCount--) > 0) {
            temp.add(0);
        }
        while ((oneCount--) > 0) {
            temp.add(1);
        }
        while ((twoCount--) > 0) {
            temp.add(2);
        }

        return temp;
    }
}
