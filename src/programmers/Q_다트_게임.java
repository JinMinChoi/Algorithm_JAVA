package programmers;

public class Q_다트_게임 {
    public static void main(String[] args) {
        Q_다트_게임 q = new Q_다트_게임();

        String d = "1T2D3D#";

        System.out.println(q.solution(d));
    }

    public int solution(String dartResult) {
        char[] darts = dartResult.toCharArray();
        int[] score = new int[3];
        int idx = -1;

        for (int i = 0; i < darts.length; i++) {
            if (isNum(darts[i])) {
                idx++;
                if (darts[i + 1] == '0') {
                    score[idx] = 10;
                    i++;
                } else {
                    score[idx] = darts[i] - '0';
                }
            } else if (darts[i] == 'D') {
                score[idx] *= score[idx];
            } else if (darts[i] == 'T') {
                score[idx] *= score[idx] * score[idx];
            } else if (darts[i] == '*') {
                if (idx > 0) {
                    score[idx - 1] *= 2;
                }
                score[idx] *= 2;
            } else if (darts[i] == '#') {
                score[idx] *= -1;
            }
        }
        return score[0] + score[1] + score[2];
    }

    private boolean isNum(char charDart) {
        return charDart >= '0' && charDart <= '9';
    }
}
