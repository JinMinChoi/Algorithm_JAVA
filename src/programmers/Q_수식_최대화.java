//https://programmers.co.kr/learn/courses/30/lessons/67257
package programmers;

import java.util.ArrayList;
import java.util.List;

public class Q_수식_최대화 {
    private static List<Long> nums = new ArrayList<>();
    private static List<String> operations = new ArrayList<>();

    private static boolean[] visit;
    private static String[] oper = {"*", "+", "-"};
    private static String[] priority;
    private static long answer = Long.MIN_VALUE;

    public static void main(String[] args) {
        Q_수식_최대화 q = new Q_수식_최대화();

        String ex = "100-200*300-500+20";
        //String ex = "50*6-3*2";

        System.out.println(q.solution(ex));
    }

    public long solution(String expression) {
        String temp = "";

        for (int i = 0; i < expression.length(); i++) {
            char ex = expression.charAt(i);

            if (isOperation(ex)) {
                operations.add(ex + "");
                nums.add(Long.parseLong(temp));
                temp = "";
            } else {
                temp += ex;
            }
        }

        nums.add(Long.parseLong(temp));
        visit = new boolean[3];
        priority = new String[3];

        permutation(0);

        return answer;
    }

    private void permutation(int depth) {
        if (depth == oper.length) {
            answer = priorityRes();
            return;
        }

        for (int i = 0; i < oper.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                priority[depth] = oper[i];
                permutation(depth + 1);
                visit[i] = false;
            }
        }
    }

    private long priorityRes() {
        List<Long> curNums = new ArrayList<>(nums);
        List<String> curOps = new ArrayList<>(operations);

        for (int i = 0; i < priority.length; i++) {
            for (int j = 0; j < curOps.size(); j++) {
                if (curOps.get(j).equals(priority[i])) {
                    Long res = cal(curNums.remove(j), curNums.remove(j), priority[i]);
                    curNums.add(j, res);
                    curOps.remove(j);
                    j--;
                }
            }
        }

        answer = Math.max(answer, Math.abs(curNums.get(0)));
        return answer;
    }

    private Long cal(Long a, Long b, String oper) {
        long temp = 0;

        switch (oper) {
            case "+":
                temp = a + b;
                break;
            case "*":
                temp = a * b;
                break;
            case "-":
                temp = a - b;
                break;
        }

        return temp;
    }

    private boolean isOperation(char c) {
        return c == '*' || c == '-' || c == '+';
    }

}
