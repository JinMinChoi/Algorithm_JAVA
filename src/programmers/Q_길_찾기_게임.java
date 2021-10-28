package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q_길_찾기_게임 {
    public static void main(String[] args) {

        int[][] ni = {
                {5, 3},
                {11, 5},
                {13, 3},
                {3, 5},
                {6, 1},
                {1, 3},
                {8, 6},
                {7, 2},
                {2, 2}
        };

        Q_길_찾기_게임 q = new Q_길_찾기_게임();
        int[][] result = q.solution(ni);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static List<Pos> positions = new ArrayList<>();
    private static int preorderIdx = 0, postorderIdx = 0;
    public int[][] solution(int[][] nodeinfo) {
        for (int i = 0; i < nodeinfo.length; i++) {
            int col = nodeinfo[i][0];
            int row = nodeinfo[i][1];
            positions.add(new Pos(i + 1, row, col));
        }

        Collections.sort(positions);
        Pos rootPos = positions.get(0);

        Tree tree = new Tree(new Node(rootPos.idx, rootPos.col));

        for (int i = 1; i < positions.size(); i++) {
            Pos nodeAndPosInfo = positions.get(i);
            tree.addNode(nodeAndPosInfo.idx, nodeAndPosInfo.col);
        }

        int[][] answer = new int[2][positions.size()];
        tree.preorder(tree.root, answer);
        tree.postorder(tree.root, answer);

        return answer;
    }

    private static class Tree {
        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        public void addNode(int idx, int col) {
            this.root = insertNode(root, idx, col);
        }

        private Node insertNode(Node root, int idx, int value) {
            Node cur = root;
            Node newNode = new Node(idx, value);

            if (cur == null) {
                return newNode;
            }

            if (cur.col_value > newNode.col_value) {
                cur.left = insertNode(cur.left, idx, value);
                return cur;
            }

            if (cur.col_value < newNode.col_value) {
                cur.right = insertNode(cur.right, idx, value);
                return cur;
            }

            return cur;
        }

        public void preorder(Node root, int[][] answer) {
            if (root != null) {
                answer[0][preorderIdx++] = root.idx;
                preorder(root.left, answer);
                preorder(root.right, answer);
            }
        }

        public void postorder(Node root, int[][] answer) {
            if (root != null) {
                postorder(root.left, answer);
                postorder(root.right, answer);
                answer[1][postorderIdx++] = root.idx;
            }
        }
    }

    private static class Node {
        int idx;
        int col_value;
        Node left;
        Node right;

        public Node(int idx, int col_value) {
            this.idx = idx;
            this.col_value = col_value;
            this.left = null;
            this.right = null;
        }
    }

    private static class Pos implements Comparable<Pos> {
        int idx;
        int row;
        int col;

        public Pos(int idx, int row, int col) {
            this.idx = idx;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Pos o) {
            if (this.row == o.row) {
                return this.col - o.col;
            }
            return o.row - this.row;
        }
    }
}
