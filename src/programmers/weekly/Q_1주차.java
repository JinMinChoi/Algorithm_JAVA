package programmers.weekly;

public class Q_1주차 {
    public static void main(String[] args) {
        Q_1주차 q = new Q_1주차();
        System.out.println(q.solution(3, 20, 4));
    }

    public long solution(int price, int money, int count) {
        long answer = 0;

        for (int i = 1; i <= count; i++) {
            answer += (long) price * i;
        }

        answer = (answer <= money) ? 0: answer - money;
        return answer;
    }
}
