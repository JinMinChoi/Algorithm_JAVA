//https://programmers.co.kr/learn/courses/30/lessons/62048
package programmers.level2;

public class Q62048 {

    public static void main(String[] args) {
        int w = 8;
        int h = 12;

        long ans = solution(w, h);
        System.out.println(ans);
    }

    public static long solution(int w, int h) {
        long answer = (long) w * (long) h;

        int gcdNum = gcd(w, h);
        int gcdW = w / gcdNum;
        int gcdH = h / gcdNum;

        int cutting = gcdNum * (gcdW + gcdH - 1);
        answer -= cutting;

        return answer;
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}
