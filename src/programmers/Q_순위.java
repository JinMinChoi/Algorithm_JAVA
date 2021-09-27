//https://programmers.co.kr/learn/courses/30/lessons/49191
package programmers;

import java.util.HashSet;

public class Q_순위 {
    private static Player[] players;

    public static void main(String[] args) {
        Q_순위 q = new Q_순위();
        int n = 8;
        int[][] r = {
                {1, 2},
                {2, 3},
                {3, 4},
                {4, 5},
                {5, 6},
                {6, 7},
                {7, 8}
        };

        System.out.println(q.solution(n, r));
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        players = new Player[n + 1];
        for (int i = 0; i <= n; i++) {
            players[i] = new Player(new HashSet<>(), new HashSet<>());
        }

        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < 2; j++) {
                int win = results[i][0];
                int lose = results[i][1];
                players[win].lose.add(lose);
                players[lose].win.add(win);
            }
        }

        for (int i = 1; i <= n; i++) {
            HashSet<Integer> loseToI = players[i].lose;
            HashSet<Integer> winToI = players[i].win;

            HashSet<Integer> copyLoseToI = new HashSet<>(loseToI);
            HashSet<Integer> copyWinToI = new HashSet<>(winToI);

            for (Integer loseP : copyLoseToI) {
                if (players[loseP].lose != null) {
                    loseToI.addAll(players[loseP].lose);
                }
            }

            for (Integer winP : copyWinToI) {
                if (players[winP].win != null) {
                    winToI.addAll(players[winP].win);
                }
            }
        }

        for (int i = n; i > 0; --i) {
            HashSet<Integer> loseToI = players[i].lose;
            HashSet<Integer> winToI = players[i].win;

            HashSet<Integer> copyLoseToI = new HashSet<>(loseToI);
            HashSet<Integer> copyWinToI = new HashSet<>(winToI);

            for (Integer loseP : copyLoseToI) {
                if (players[loseP].lose != null) {
                    loseToI.addAll(players[loseP].lose);
                }
            }

            for (Integer winP : copyWinToI) {
                if (players[winP].win != null) {
                    winToI.addAll(players[winP].win);
                }
            }
        }

        //print();

        for (Player player : players) {
            HashSet<Integer> win = player.win;
            HashSet<Integer> lose = player.lose;

            if (win.size() + lose.size() == n - 1) {
                answer++;
            }
        }
        return answer;
    }

    private static void print(){
        for (int i = 1; i < players.length; i++) {
            Player player = players[i];
            HashSet<Integer> win = player.win;
            HashSet<Integer> lose = player.lose;

            System.out.println("player " + i);

            System.out.print("에게 이긴사람: ");
            for (Integer integer : win) {
                System.out.print(integer + " ");
            }
            System.out.println();

            System.out.print("에게 진사람 ");
            for (Integer integer : lose) {
                System.out.print(integer + " ");
            }

            System.out.println();
        }
    }

    private static class Player {
        private HashSet<Integer> win;
        private HashSet<Integer> lose;

        public Player(HashSet<Integer> win, HashSet<Integer> lose) {
            this.win = win;
            this.lose = lose;
        }
    }
}
