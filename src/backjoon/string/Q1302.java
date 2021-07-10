//https://www.acmicpc.net/problem/1302
package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> hm = new HashMap<>();

        String maxBook = "";
        int max = 0;

        while ((n--) > 0) {
            String str = br.readLine();

            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }

        for (String key : hm.keySet()) {
            int value = hm.get(key);

            if (max == value && maxBook.compareTo(key) > 0) {
                maxBook = key;
                max = value;
            } else if (max < value) {
                maxBook = key;
                max = value;
            }
        }
        System.out.println(maxBook);
    }
}
