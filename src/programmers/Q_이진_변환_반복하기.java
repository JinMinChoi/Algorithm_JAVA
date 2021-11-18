package programmers;

public class Q_이진_변환_반복하기 {
    static int zeroCnt = 0;
    static int conversionDigitCnt = 0;

    public static void main(String[] args) {
        Q_이진_변환_반복하기 q = new Q_이진_변환_반복하기();

        String s = "110010101001";

        int[] ans = q.solution(s);

        for (int an : ans) {
            System.out.println(an);
        }
    }

    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            s = eraseZero(s);
            s = conversionDigit(s);
        }

        answer[0] = conversionDigitCnt;
        answer[1] = zeroCnt;
        return answer;
    }

    private String conversionDigit(String s) {
        conversionDigitCnt++;
        StringBuilder sb = new StringBuilder();
        int len = s.length();

        while (len > 0) {
            sb.append(len % 2);
            len /= 2;
        }

        return sb.reverse().toString();
    }

    private String eraseZero(String s) {
        String temp = "";

        char[] sArr = s.toCharArray();
        for (char c : sArr) {
            if (c == '0') {
                zeroCnt++;
            } else {
                temp += c;
            }
        }
        return temp;
    }
}
