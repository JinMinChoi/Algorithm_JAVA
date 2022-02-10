package inflearnLecture.question.recursion2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q86 {
    private static int n, m;
    private static int[][] map;
    private static ArrayList<Pos> houses = new ArrayList<>();
    private static ArrayList<Pos> pizzas = new ArrayList<>();
    private static int allPizzaCnt;
    private static int[] openPizza;
    private static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        openPizza = new int[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    houses.add(new Pos(i, j));
                } else if (map[i][j] == 2) {
                    pizzas.add(new Pos(i, j));
                }
            }
        }

        allPizzaCnt = pizzas.size();

        dfsPizza(0, 0);
        System.out.println(answer);
    }

    private static void dfsPizza(int depth, int cur) {
        if (depth == m) {
            int sum = getMin(openPizza);
            answer = Math.min(sum, answer);
            return;
        }

        for (int i = cur; i < allPizzaCnt; i++) {
            openPizza[depth] = i;
            dfsPizza(depth + 1, i + 1);
        }
    }

    private static int getMin(int[] openPizza) {
        int sum = 0;

        for (Pos house : houses) {
            int min = Integer.MAX_VALUE;

            for (int openPizzaIdx : openPizza) {
                Pos pos = pizzas.get(openPizzaIdx);

                int distance = Math.abs(house.x - pos.x) + Math.abs(house.y - pos.y);
                min = Math.min(min, distance);
            }
            sum += min;
        }
        return sum;
    }

    private static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
