package backjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Q17178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String> originTickets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] strSplit = br.readLine().split(" ");
            originTickets.addAll(Arrays.asList(strSplit));
        }
        ArrayList<String> sortedTickets = new ArrayList<>(originTickets);
        sortedTickets.sort((o1, o2) -> {
            String[] s1 = o1.split("-");
            String[] s2 = o2.split("-");

            if (s1[0].charAt(0) == s2[0].charAt(0)) {
                return Integer.parseInt(s1[1]) - Integer.parseInt(s2[1]);
            }
            return s1[0].charAt(0) - s2[0].charAt(0);
        });

        Stack<String> stack = new Stack<>();
        int i = 0, j = 0;
        while (i < n * 5 && j < n * 5) {
            if (originTickets.get(i).equals(sortedTickets.get(j))) { // 두 리스트의 값이 같을 때
                i++;
                j++;
            } else if (!stack.isEmpty() && stack.peek().equals(sortedTickets.get(j))) { // 인덱스가 가르키는 값은 다르지만, 스택이 가르키는 값과 정렬된 값이 같을 때
                stack.pop();
                j++;
            } else { // 위의 두 조건을 만족하지 못할 때
                stack.push(originTickets.get(i));
                i++;
            }
        }

        boolean ans = true;
        while (!stack.isEmpty()) {
            if (!stack.peek().equals(sortedTickets.get(j++))) {
                ans = false;
                break;
            }
            stack.pop();
        }

        if (ans) {
            System.out.println("GOOD");
        } else {
            System.out.println("BAD");
        }
    }
}
