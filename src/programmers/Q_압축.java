//https://programmers.co.kr/learn/courses/30/lessons/17684
package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q_압축 {
    private static HashMap<String, Integer> dic = new HashMap<>();
    private static int start = 0, n, addIndex = 26;
    private static char[] cArr;

    public static void main(String[] args) {
        Q_압축 q = new Q_압축();

        String msg = "TOBEORNOTTOBEORTOBEORNOT";

        int[] ret = q.solution(msg);

        for (int value : ret) {
            System.out.print(value + " ");
        }
    }

    public int[] solution(String msg) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList<>();
        cArr = msg.toCharArray();

        initMap();
        n = msg.length();

        while (start != n) {
            String w = findW();
            answerList.add(dic.get(w));
        }

        answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private String findW() {
        StringBuilder sb = new StringBuilder();
        boolean inMap = false;

        for (int i = start; i < n; i++) {
            sb.append(cArr[i]);
            if (!dic.containsKey(sb.toString())) {
                dic.put(sb.toString(), ++addIndex);
                inMap = true;
                break;
            }
        }

        start += inMap ? sb.length() - 1 : sb.length();
        return inMap ? sb.substring(0, sb.length() - 1) : sb.toString();
    }

    private void initMap() {
        char a = 'A';
        for (int i = 0; i < 26; i++) {
            dic.put(String.valueOf(a++), i + 1);
        }
    }
}
