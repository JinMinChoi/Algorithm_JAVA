package inflearnLecture.question.sortAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q53 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> digitMap = new HashMap<>();
        digitMap.put(10, "A");
        digitMap.put(11, "B");
        digitMap.put(12, "C");
        digitMap.put(13, "D");
        digitMap.put(14, "E");
        digitMap.put(15, "F");

        Stack<String> s = new Stack<>();

        while (n > 0) {
            int r = n % k;
            if (digitMap.containsKey(r)) {
                s.add(digitMap.get(r));
            } else {
                s.add(String.valueOf(r));
            }
            n /= k;
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }

        System.out.println(sb);
    }
}
