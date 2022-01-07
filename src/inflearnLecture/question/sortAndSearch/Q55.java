package inflearnLecture.question.sortAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q55 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int check = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int train = Integer.parseInt(st.nextToken());

            stack.push(train);
            sb.append("P");
            while (!stack.isEmpty() && stack.peek() == check) {
                sb.append("O");
                stack.pop();
                check++;
            }
        }

        if (!stack.isEmpty()) System.out.println("impossible");
        else System.out.println(sb);
    }
}
