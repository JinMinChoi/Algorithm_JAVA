//https://www.acmicpc.net/problem/14891
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14891 {

    private static int[][] gear = new int[4][8];
    private static int[] gearRotate;

    public static void main(String[] args) throws IOException {
        long answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                gear[i][j] = Integer.parseInt(line[j]);
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            gearRotate = new int[4];

            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int rotateNum = Integer.parseInt(st.nextToken());

            makeGearRotate(gearNum, rotateNum);
            rotate(gearRotate);
        }

        for (int i = 0; i < 4; i++) {
            if (gear[i][0] == 1) {
                answer += Math.pow(2, i);
            }
        }
        System.out.println(answer);
    }

    private static void rotate(int[] gearRotate) {
        for (int i = 0; i < 4; i++) {
            int dir = gearRotate[i];

            String temp = "";
            for (int pole : gear[i]) {
                temp += String.valueOf(pole);
            }

            if (dir == -1) {
                String first = temp.substring(0, 1);
                temp = temp.substring(1) + first;
            } else if (dir == 1) {
                String last = temp.substring(temp.length() - 1);
                temp = last + temp.substring(0, temp.length() - 1);
            }

            for (int j = 0; j < 8; j++) {
                gear[i][j] = Integer.parseInt(temp.split("")[j]);
            }
        }
    }

    private static void makeGearRotate(int gearNum, int rotateNum) {
        gearRotate[gearNum] = rotateNum;

        int leftGear = gearNum - 1;
        int rightGear = gearNum + 1;

        if (leftGear >= 0 && gearRotate[leftGear] == 0) {
            if (gear[gearNum][6] != gear[leftGear][2]) {
                makeGearRotate(leftGear, rotateNum * (-1));
            }
        }

        if (rightGear < 4 && gearRotate[rightGear] == 0) {
            if (gear[gearNum][2] != gear[rightGear][6]) {
                makeGearRotate(rightGear, rotateNum * (-1));
            }
        }
    }

}
