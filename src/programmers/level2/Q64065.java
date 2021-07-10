//https://programmers.co.kr/learn/courses/30/lessons/64065
package programmers.level2;

import java.util.*;

public class Q64065 {

    public static void main(String[] args) {
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
        int[] ans = solution(s);
        for (int an : ans) {
            System.out.println("an = " + an);
        }
    }

    static int[] solution(String s) {
        int[] answer = {};

        Map<String, Integer> map = new HashMap<>();

        s = s.replace("{", "");
        s = s.replace("}", "");

        String[] strings = s.split(",");

        for (String string : strings) {
            int cnt = map.containsKey(string) ? map.get(string) + 1 : 1;
            map.put(string, cnt);
        }

        List<String> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));

        answer = new int[map.size()];
        int i = 0;
        for (String s1 : keySetList) {
            answer[i] = Integer.parseInt(s1);
            i++;
        }

        return answer;
    }
}
