//https://programmers.co.kr/learn/courses/30/lessons/64061
package programmers;

import java.util.Stack;

public class Q_크레인_인형뽑기_게임 {
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}};
        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        Q_크레인_인형뽑기_게임 q = new Q_크레인_인형뽑기_게임();
        System.out.println(q.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int h = board.length;
        int w = board[0].length;

        Stack<Integer> basket = new Stack<>();

        for (int move : moves) {
            int claw = move - 1;

            for (int i = 0; i < w; i++) {
                int target = board[i][claw];
                if (target == 0) {
                    continue;
                }
                else {
                    if (basket.isEmpty() || basket.peek() != target) {
                        basket.add(target);
                        board[i][claw] = 0;
                        break;
                    } else {
                        basket.pop();
                        board[i][claw] = 0;
                        answer += 2;
                        break;
                    }
                }
            }
            printBoard(board);
            printStack(basket);
            System.out.println();
        }
        return answer;
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printStack(Stack<Integer> stack) {
        for (Integer integer : stack) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
