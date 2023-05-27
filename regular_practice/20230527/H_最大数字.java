import java.util.*;
import java.io.*;

public class H_最大数字 {
    static int n;
    static int[] num;
    static long ans;

    static void dfs(int u, int inc, int dec) {
        if (u == n) {
            long t = 0;
            for (int x : num) t = t * 10 + x;
            ans = Math.max(ans, t);
            return;
        }
        int d = num[u];
        int up = 9 - d, down = d + 1;
        if (up <= inc) {
            num[u] = 9;
            dfs(u + 1, inc - up, dec);
            num[u] = d;
        }
        if (down <= dec) {
            num[u] = 9;
            dfs(u + 1, inc, dec - down);
            num[u] = d;
        }
        if (up > inc && down > dec) {
            num[u] += inc;
            dfs(u + 1, 0, dec);
            num[u] = d;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        int a = in.nextInt(), b = in.nextInt();
        n = s.length;
        num = new int[n];
        for (int i = 0; i < n; ++i) num[i] = s[i] - '0';
        dfs(0, a, b);
        System.out.println(ans);
    }
}
