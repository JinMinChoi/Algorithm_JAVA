//https://programmers.co.kr/learn/courses/30/lessons/17685
package programmers;

import java.util.HashMap;

public class Q_자동완성 {
    static Node root = new Node();

    public static void main(String[] args) {

        String[] words = {"go", "gone", "guild"};

        Q_자동완성 q = new Q_자동완성();
        System.out.println(q.solution(words));

    }
    public int solution(String[] words) {
        int answer = 0;

        for (String word : words) {
            insert(word);
        }

        answer = cal(root, 0);
        return answer;
    }

    static int cal(Node root, int depth) {
        if (root.maxDepth == 1) {
            return depth;
        }
        int cnt = 0;

        for (char key : root.childNode.keySet()) {
            if (key == '-') {
                cnt += depth;
            } else {
                cnt += cal(root.childNode.get(key), depth + 1);
            }
        }

        return cnt;
    }

    static void insert(String word) {
        Node currentNode = root;

        for (char c : word.toCharArray()) {
            Node newRoot = currentNode.put(c);
            currentNode = newRoot;
        }

        currentNode.put('-');
    }

    static class Node {
        private HashMap<Character, Node> childNode = new HashMap<>();
        private int maxDepth = 0;

        Node put(char c) {
            maxDepth++;
            if (!childNode.containsKey(c)) {
                childNode.put(c, new Node());
            }

            return childNode.get(c);
        }
    }
}
