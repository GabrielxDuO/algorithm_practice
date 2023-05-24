import java.util.*;
import java.io.*;

public class _分巧克力 {
    static int n, k;
    static int[][] chocos;
    static boolean check(int m) {
        int cnt = 0;
        for (int[] choco : chocos) {
            if ((cnt += (choco[0] / m) * (choco[1] / m)) >= k) return true;
        }
        return cnt >= k;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        in.nextToken();
        k = (int) in.nval;
        int l = 1, r = 0;
        chocos = new int[n][2];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            int h = (int) in.nval;
            in.nextToken();
            int w = (int) in.nval;
            r = Math.max(r, Math.min(h, w));
            chocos[i][0] = h;
            chocos[i][1] = w;
        }
        while (l < r) {
            int m = l + r + 1 >> 1;
            if (check(m)) l = m;
            else r = m - 1;
        }
        System.out.println(l);
    }
}
