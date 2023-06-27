import java.util.*;
import java.io.*;

public class _032 {
    static final int N = 1_010;
    static int n, m, k;
    static int[] stk = new int[N];
    static int tt;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); n = (int) in.nval;
        in.nextToken(); m = (int) in.nval;
        in.nextToken(); k = (int) in.nval;
        StringBuilder ans = new StringBuilder();
        while (k-- > 0) {
            boolean flag = false;
            tt = 0;
            int curr = 1;
            for (int i = 1; i <= n; ++i) {
                in.nextToken(); int x = (int) in.nval;
                if (curr == x) {
                    ++curr;
                    while (curr == stk[tt]) {
                        ++curr;
                        --tt;
                    }
                } else stk[++tt] = x;
                if (tt > m) flag = true;
            }
            ans.append(flag || tt != 0 ? "NO\n" : "YES\n");
        }
        System.out.print(ans);
    }
}
