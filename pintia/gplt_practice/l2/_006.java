import java.io.*;
import java.util.*;

public class _006 {
    static final int N = 35;
    static int n;
    static int[] inod = new int[N];
    static int[] post = new int[N];
    static int pi;
    static class Node {
        int val;
        Node l, r;

        Node(int x) {
            val = x;
        }
    }

    static Node dfs(int st, int ed) {
        if (st > ed) {
            return null;
        }
        int pv = post[pi];
        int idx = 0;
        for (int i = st; i <= ed; ++i) {
            if (inod[i] == pv) {
                idx = i;
                break;
            }
        }
        --pi;
        Node p = new Node(pv);
        p.r = dfs(idx + 1, ed);
        p.l = dfs(st, idx - 1);
        return p;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        pi = n;
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); post[i] = (int) in.nval;
        }
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); inod[i] = (int) in.nval;
        }
        Node root = dfs(1, n);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node u = queue.poll();
            if (u == null) {
                continue;
            }
            System.out.print(u.val);
            System.out.print(--n > 0 ? " " : "\n");
            queue.add(u.l);
            queue.add(u.r);
        }
    }
}
