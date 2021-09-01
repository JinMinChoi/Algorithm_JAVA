//https://programmers.co.kr/learn/courses/30/lessons/72410
package programmers;

public class Q_신규_아이디_추천 {
    public static void main(String[] args) {
        String a = "abcdefghijklmn.p";
        //"...!@BaT#*..y.abcdefghijklm";
        //"z-+.^.";
        //"=.=";
        //"123_.def";
        //"abcdefghijklmn.p";

        Q_신규_아이디_추천 q = new Q_신규_아이디_추천();
        System.out.println(q.solution(a));
    }

    public String solution(String new_id) {
        String answer = new_id.toLowerCase(); //1

        answer = answer.replaceAll("[^-_.a-z0-9]", ""); //2
        answer = answer.replaceAll("[.]{2,}", "."); //3
        answer = answer.replaceAll("^[.]|[.]$", ""); //4

        if (answer.equals("")) { //5
            answer += "a";
        }

        if (answer.length() > 15) {
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }


        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }
        return answer;
    }
}
