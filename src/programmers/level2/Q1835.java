//https://programmers.co.kr/learn/courses/30/lessons/1835?language=java
package programmers.level2;

import java.util.HashMap;

public class Q1835 {

    static int position[];
    static boolean visit[];
    static int cnt;
    static HashMap<Character, Integer> map;
    static boolean ok;

    public static void main(String[] args) {
        int n = 2;
        String[] data1 = {"N~F=0", "R~T>2"};
        String[] data2 = {"M~C<2", "C~M>1"};

        System.out.println(solution(n, data1));
    }

    private static int solution(int n, String[] data) {
        int answer = 0;

        position = new int[8];
        visit = new boolean[8];

        cnt = 0;
        map = new HashMap<>();
        ok = true;

        map.put('A', 0);
        map.put('C', 1);
        map.put('F', 2);
        map.put('J', 3);
        map.put('M', 4);
        map.put('N', 5);
        map.put('R', 6);
        map.put('T', 7);

        perm(0, data);

        answer = cnt;
        return answer;
    }

    private static void perm(int idx, String[] data) {

        if (idx == 8) {
            if (isOk(data)) {
                cnt++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visit[i]) {
                visit[i] = true;
                position[idx] = i;
                perm(idx + 1, data);
                visit[i] = false;
            }
        }
    }

    private static boolean isOk(String[] data) {
        for (int i = 0; i < data.length; i++) {
            int first = map.get(data[i].charAt(0));
            int second = map.get(data[i].charAt(2));
            char type = data[i].charAt(3);
            int diff = data[i].charAt(4) - '0';
            int firstPos = position[first];
            int secondPos = position[second];

            if (type == '=') {
                if (Math.abs(firstPos - secondPos) - 1 != diff) {
                    return false;
                }
            } else if (type == '>') {
                if (Math.abs(firstPos - secondPos) - 1 <= diff) {
                    return false;
                }
            } else if (type == '<') {
                if (Math.abs(firstPos - secondPos) - 1 >= diff) {
                    return false;
                }
            }
        }

        return true;
    }
}