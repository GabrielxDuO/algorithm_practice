import java.util.*;
import java.io.*;

public class _最大数字 {
    static int n;
    static int[] num;
    static long ans = 0L;

    static void dfs(int i, int inc, int dec) {
        if (i == n) {
            long res = 0L;
            for (int x : num) res = res * 10 + x;
            ans = Math.max(res, ans);
            return;
        }
        int d = num[i], up = 9 - d, down = d + 1;
        int ori = num[i];
        if (inc >= up) {
            num[i] = 9;
            dfs(i + 1, inc - up, dec);
            num[i] = ori;
        }
        if (dec >= down) {
            num[i] = 9;
            dfs(i + 1, inc, dec - down);
            num[i] = ori;
        }
        if (inc < up && dec < down) {
            num[i] += inc;
            dfs(i + 1, 0, dec);
            num[i] = ori;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        char[] s = in.next().toCharArray();
        n = s.length;
        num = new int[n];
        for (int i = 0; i < n; ++i) num[i] = s[i] - '0';
        int inc = in.nextInt(), dec = in.nextInt();
        dfs(0, inc, dec);
        System.out.println(ans);
    }
}
