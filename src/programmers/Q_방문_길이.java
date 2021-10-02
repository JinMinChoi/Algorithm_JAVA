//https://programmers.co.kr/learn/courses/30/lessons/49994
package programmers;

import java.util.ArrayList;
import java.util.List;

public class Q_방문_길이 {
    private static List<Line> lines = new ArrayList<>();

    public static void main(String[] args) {
        String s = "LRLRL";
        Q_방문_길이 q = new Q_방문_길이();
        System.out.println(q.solution(s));
    }

    public int solution(String dirs) {
        int answer = 1;

        int curX = 0;
        int curY = 0;
        int nextX = 0;
        int nextY = 0;

        for (int i = 0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);
            switch (dir) {
                case 'U':
                    nextY = curY + 1;
                    break;
                case 'D':
                    nextY = curY - 1;
                    break;
                case 'R':
                    nextX = curX + 1;
                    break;
                case 'L':
                    nextX = curX - 1;
                    break;
            }

            if (isOutX(nextX)) {
                nextX = curX;
                continue;
            }
            if (isOutY(nextY)) {
                nextY = curY;
                continue;
            }

            if (!includeLine(curX, curY, nextX, nextY) && !lines.isEmpty()) {
                answer++;
            }

            lines.add(new Line(curX, curY, nextX, nextY));

            curX = nextX;
            curY = nextY;
        }

        int i = 1;
        for (Line line : lines) {
            System.out.println(i + "선분 : " + line.curX + " " + line.curY + " " + line.nextX + " " + line.nextY);
            i++;
        }

        return answer;
    }

    private boolean isOutX(int nextX) {
        return nextX < -5 || nextX > 5;
    }

    private boolean isOutY(int nextY) {
        return nextY < -5 || nextY > 5;
    }

    private boolean includeLine(int curX, int curY, int nextX, int nextY) {
        for (Line line : lines) {
            if ((line.curX == curX && line.curY == curY && line.nextX == nextX && line.nextY == nextY) ||
                    (line.curX == nextX && line.curY == nextY && line.nextX == curX && line.nextY == curY)
            ) {
                return true;
            }
        }
        return false;
    }

    private static class Line {
        int curX;
        int curY;
        int nextX;
        int nextY;

        public Line(int curX, int curY, int nextX, int nextY) {
            this.curX = curX;
            this.curY = curY;
            this.nextX = nextX;
            this.nextY = nextY;
        }
    }
}
