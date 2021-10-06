//https://www.acmicpc.net/problem/4307
package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q4307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while ((tc--) > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            List<Integer> ants = new ArrayList<>();
            ants.add(0);
            ants.add(l);

            for (int i = 0; i < n; i++) {
                int ant = Integer.parseInt(br.readLine());
                ants.add(ant);
            }

            Collections.sort(ants);

            int mid = l / 2;
            int biggest = 0;
            int smallest = l;

            for (int i = 0; i < ants.size(); i++) {
                if (mid >= ants.get(i) && ants.get(i) > biggest) {
                    biggest = ants.get(i);
                } else if (mid <= ants.get(i) && ants.get(i) < smallest) {
                    smallest = ants.get(i);
                }
            }

            int min = Math.max(l - smallest, biggest);
            int max = Math.max(l - ants.get(1), ants.get(ants.size() - 2));

            System.out.println(min + " " + max);
        }
    }
}
