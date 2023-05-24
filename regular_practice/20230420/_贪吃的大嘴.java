import java.util.*;
import java.io.*;

public class _贪吃的大嘴 {
    static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int m = (int) in.nval;
        in.nextToken(); int n = (int) in.nval;
        int[] v = new int[100], w = new int[100];
        int cnt = 0;
        while (n-- > 0) {
            in.nextToken(); int vi = (int) in.nval;
            in.nextToken(); int si = (int) in.nval;
            int x = 1;
            while (si >= x) {
                v[cnt] = vi * x;
                w[cnt] = x;
                ++cnt;
                si -= x;
                x <<= 1;
            }
            if (si > 0) {
                v[cnt] = vi * si;
                w[cnt] = si;
                ++cnt;
            }
        }
        n = cnt;
        int[] f = new int[m + 1];
        Arrays.fill(f, INF);
        f[0] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = m; j >= v[i]; --j) {
                f[j] = Math.min(f[j], f[j - v[i]] + w[i]);
            }
        }
        System.out.println(f[m] == INF ? "><" : f[m]);
    }
}
