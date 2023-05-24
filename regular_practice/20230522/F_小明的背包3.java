import java.util.*;
import java.io.*;

public class F_小明的背包3 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int c = (int) in.nval;
        int[] f = new int[c + 1], g;
        int[] que = new int[c + 1];
        int hh = 0, tt = -1;
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); int v = (int) in.nval;
            in.nextToken(); int w = (int) in.nval;
            in.nextToken(); int s = (int) in.nval;
            g = f.clone();
            for (int r = 0; r < v; ++r) {
                hh = 0; tt = -1;
                for (int j = r; j <= c; j += v) {
                    while (hh <= tt && (j - que[hh]) / v > s) ++hh;
                    while (hh <= tt && g[j] >= g[que[tt]] + (j - que[tt]) / v * w) --tt;
                    que[++tt] = j;
                    f[j] = g[que[hh]] + (j - que[hh]) / v * w;
                }
            }
        }
        System.out.println(f[c]);
    }
}
