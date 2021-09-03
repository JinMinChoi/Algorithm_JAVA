//https://programmers.co.kr/learn/courses/30/lessons/76501
package programmers;

public class Q_음양_더하기 {
    public static void main(String[] args) {
        int[] absolutes = {1, 2, 3};
        boolean[] signs = {true, true, false};
        Q_음양_더하기 q = new Q_음양_더하기();
        System.out.println(q.solution(absolutes, signs));

    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for (int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                answer += absolutes[i];
            } else {
                answer -= absolutes[i];
            }
        }

        return answer;
    }
}
