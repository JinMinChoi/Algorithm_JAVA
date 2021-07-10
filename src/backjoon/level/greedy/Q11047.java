package backjoon.level.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list, Collections.reverseOrder());
        int cnt = 0;

        while (k != 0) {
            int max = 0;

            for (int j = 0; j < n; j++) {
                if (max < list.get(j) && list.get(j) <= k) {
                    max = list.get(j);
                }
            }

            cnt += k / max;

            k %= max;
        }

        System.out.println(cnt);
    }
}
