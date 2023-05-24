import java.util.*;
import java.io.*;

public class C_调手表 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt();
        Queue<Integer> que = new LinkedList<>();
        boolean[] vis = new boolean[n];
        int cnt = 0;
        que.offer(0);
        vis[0] = true;
        int step = 0;
        outer: while (!que.isEmpty()) {
            int sz = que.size();
            while (sz-- > 0) {
                int x = que.poll();
                if (++cnt == n) break outer;
                int y = (x + 1) % n;
                if (!vis[y]) {
                    que.offer(y);
                    vis[y] = true;
                }
                y = (x + k) % n;
                if (!vis[y]) {
                    que.offer(y);
                    vis[y] = true;
                }
            }
            ++step;
        }
        System.out.println(step);
    }
}
