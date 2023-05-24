import java.io.*;
import java.util.*;

public class C_装饰珠 {
    static final int N = 10010;
    
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int[] cnts = new int[5];
        for (int i = 0; i < 6; ++i) {
            in.nextToken();
            int n = (int) in.nval;
            while (n-- > 0) {
                in.nextToken();
                int l = (int) in.nval;
                ++cnts[l];
            }
        }
        for (int i = 4; i > 0; --i) cnts[i - 1] += cnts[i];
        in.nextToken();
        int m = (int) in.nval;
        int[] l = new int[N], p = new int[N];
        int[][] w = new int[N][10];
        for (int i = 1; i <= m; ++i) {
            in.nextToken();
            l[i] = (int) in.nval;
            in.nextToken();
            p[i] = (int) in.nval;
            for (int j = 1; j <= p[i]; ++j) {
                in.nextToken();
                w[i][j] = (int) in.nval;
            }
        }
        int[] f = new int[N];
        int ans = 0;
        for (int x = 4; x > 0; --x) {
            for (int i = 1; i <= m; i++) {
                if (l[i] != x) continue;
                for (int j = cnts[x]; j >= 0; j--) {
                    for (int k = 0; k <= p[i]; k++) {
                        if (k <= j) f[j] = Math.max(f[j], f[j - k] + w[i][k]);
                    }
                    ans = Math.max(ans, f[j]);
                }
            }
        }
        System.out.println(ans);
    }
}