//https://www.acmicpc.net/problem/2002
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Q2002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<String> cars = new LinkedList<>();

        int answer = 0;

        for (int i = 0; i < n; i++) {
            cars.add(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            String firstCar = br.readLine();

            if (!firstCar.equals(cars.peek())) {
                answer++;
                cars.remove(firstCar);
            } else {
                cars.poll();
            }
        }

        System.out.println(answer);
    }
}
