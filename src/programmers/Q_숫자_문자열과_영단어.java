//https://programmers.co.kr/learn/courses/30/lessons/81301
package programmers;

public class Q_숫자_문자열과_영단어 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        //"23four5six7"
        //"2three45sixseven"
        //"123"
        Q_숫자_문자열과_영단어 q = new Q_숫자_문자열과_영단어();
        System.out.println("q.solution(s) = " + q.solution(s));
    }

    public int solution(String s) {
        int answer = 0;
        s = s.replaceAll("zero", "0");
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");

        answer = Integer.parseInt(s);

        return answer;
    }
}
