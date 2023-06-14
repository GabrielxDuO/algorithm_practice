import java.io.*;
import java.util.*;

public class _011 {
    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
        }
    }
    static final int N = 35;
    static int n;
    static int[] pre = new int[N];
    static int[] ino = new int[N];
    static Map<Integer, Integer> mp = new HashMap<>();
    static int p;
    static int[] tr = new int[N];

    static Node build(int st, int ed) {
        if (st > ed) return null;
        int pv = pre[p];
        int pi = mp.get(pv);
        Node node = new Node(pv);
        ++p;
        node.left = build(st, pi - 1);
        node.right = build(pi + 1, ed);
        return node;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer tokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        tokenizer.nextToken();
        n = (int) tokenizer.nval;

        for (int i = 1; i <= n; ++i) {
            tokenizer.nextToken();
            ino[i] = (int) tokenizer.nval;
            mp.put(ino[i], i);
        }

        for (int i = 1; i <= n; ++i) {
            tokenizer.nextToken();
            pre[i] = (int) tokenizer.nval;
        }

        p = 1;
        Node root = build(1, n);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node u = queue.poll();
            if (u == null) continue;
            System.out.print(u.val);
            System.out.print(--n > 0 ? " " : "\n");
            queue.offer(u.right);
            queue.offer(u.left);
        }
    }
}
