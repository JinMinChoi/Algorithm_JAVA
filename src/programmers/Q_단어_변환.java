//https://programmers.co.kr/learn/courses/30/lessons/43163
package programmers;

public class Q_단어_변환 {
    private static boolean[] visit;
    private static int ans;

    public static void main(String[] args) {
        String b = "hit";
        String t = "cog";

        String[] ws = {"hot", "dot", "dog", "lot", "log", "cog"};

        Q_단어_변환 q = new Q_단어_변환();

        System.out.println(q.solution(b, t, ws));
    }

    public int solution(String begin, String target, String[] words) {
        visit = new boolean[words.length];
        dfs(begin, target, words, 0);
        return ans;
    }

    private void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            ans = cnt;
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visit[i] && oneCharDiffer(words[i], begin)) {
                visit[i] = true;
                dfs(words[i], target, words, cnt + 1);
                visit[i] = false;
            }
        }
    }

    private boolean oneCharDiffer(String word, String begin) {
        if (word.length() != begin.length()) return false;

        int differCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != begin.charAt(i)) {
                differCount++;
            }
        }

        return differCount == 1;
    }
}
