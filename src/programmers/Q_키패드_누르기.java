//https://programmers.co.kr/learn/courses/30/lessons/67256
package programmers;

import java.util.HashMap;
import java.util.Stack;

public class Q_키패드_누르기 {
    private static StringBuilder sb = new StringBuilder();
    private static Stack<Pos> curL = new Stack<>();
    private static Stack<Pos> curR = new Stack<>();
    private static int disL = 0;
    private static int disR = 0;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String hand = "right";
        Q_키패드_누르기 q = new Q_키패드_누르기();
        System.out.println(q.solution(nums, hand));
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int x, y;
        HashMap<Integer, Pos> hm = new HashMap<>();
        hm.put(1, new Pos(0, 0));
        hm.put(2, new Pos(1, 0));
        hm.put(3, new Pos(2, 0));
        hm.put(4, new Pos(0, 1));
        hm.put(5, new Pos(1, 1));
        hm.put(6, new Pos(2, 1));
        hm.put(7, new Pos(0, 2));
        hm.put(8, new Pos(1, 2));
        hm.put(9, new Pos(2, 2));
        hm.put(0, new Pos(1, 3));

        Pos indicate;
        String lr;
        curL.add(new Pos(0, 3));
        curR.add(new Pos(2, 3));

        for (int number : numbers) {
            switch (number) {
                case 1:
                    sb.append("L");
                    curL.add(hm.get(1));
                    break;
                case 4:
                    sb.append("L");
                    curL.add(hm.get(4));
                    break;
                case 7:
                    sb.append("L");
                    curL.add(hm.get(7));
                    break;
                case 3:
                    sb.append("R");
                    curR.add(hm.get(3));
                    break;
                case 6:
                    sb.append("R");
                    curR.add(hm.get(6));
                    break;
                case 9:
                    sb.append("R");
                    curR.add(hm.get(9));
                    break;
                case 2:
                    indicate = hm.get(2);
                    disL = calculateDistance(indicate, curL.peek());
                    disR = calculateDistance(indicate, curR.peek());
                    lr = returnLR(disL, disR, hand);
                    sb.append(lr);
                    if (lr.equals("L")) {
                        curL.add(indicate);
                    } else {
                        curR.add(indicate);
                    }
                    break;
                case 5:
                    indicate = hm.get(5);
                    disL = calculateDistance(indicate, curL.peek());
                    disR = calculateDistance(indicate, curR.peek());
                    lr = returnLR(disL, disR, hand);
                    sb.append(lr);
                    if (lr.equals("L")) {
                        curL.add(indicate);
                    } else {
                        curR.add(indicate);
                    }
                    break;
                case 8:
                    indicate = hm.get(8);
                    disL = calculateDistance(indicate, curL.peek());
                    disR = calculateDistance(indicate, curR.peek());
                    lr = returnLR(disL, disR, hand);
                    sb.append(lr);
                    if (lr.equals("L")) {
                        curL.add(indicate);
                    } else {
                        curR.add(indicate);
                    }
                    break;
                case 0:
                    indicate = hm.get(0);
                    disL = calculateDistance(indicate, curL.peek());
                    disR = calculateDistance(indicate, curR.peek());
                    lr = returnLR(disL, disR, hand);
                    sb.append(lr);
                    if (lr.equals("L")) {
                        curL.add(indicate);
                    } else {
                        curR.add(indicate);
                    }
                    break;
            }
        }

        return answer = sb.toString();
    }

    private static int calculateDistance(Pos indicate, Pos cur) {
        return Math.abs(indicate.x - cur.x) + Math.abs(indicate.y - cur.y);
    }

    private static String returnLR(int l, int r, String hand) {
        String res;

        if (l < r) {
            res = "L";
        } else if (l > r) {
            res = "R";
        } else {
            if (hand.equals("right")) {
                res = "R";
            } else {
                res = "L";
            }
        }
        return res;
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
