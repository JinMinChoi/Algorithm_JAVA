//https://www.acmicpc.net/problem/1755
package backjoon.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q1755 {
    private static List<Info> list;
    private static String[] numToStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList<>(m - n + 1);

        for (int i = n; i <= m; i++) {
            String str = String.valueOf(i);
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < str.length(); j++) {
                sb.append(numToStr[str.charAt(j) - '0']);

                if (str.length() > 1) { //두 자릿수의 수일 경우
                    sb.append(" ");
                }
            }
            list.add(new Info(sb.toString(), i));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).num + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }

    private static class Info implements Comparable<Info> {
        String word;
        int num;

        public Info(String word, int num) {
            this.word = word;
            this.num = num;
        }

        @Override
        public int compareTo(Info o) {
            return this.word.compareTo(o.word);
        }
    }
}
