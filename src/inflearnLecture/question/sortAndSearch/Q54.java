package inflearnLecture.question.sortAndSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Q54 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        String answer = "";

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    answer = "NO";
                    System.out.println(answer);
                    return;
                }
                if (stack.peek() == '(') {
                    stack.pop();
                }
            }
            //printStack(stack);
        }
        //((()())())))
        if (stack.isEmpty()) answer = "YES";
        else answer = "NO";

        System.out.println(answer);
    }

    private static void printStack(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        for (Character character : stack) {
            sb.append(character);
        }
        System.out.println(sb);
    }
}
