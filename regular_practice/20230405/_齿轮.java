import java.util.*;
import java.io.*;

public class _齿轮 {
    static final int N = (int) 2e5 + 10;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int q = (int) in.nval;
        int[] r = new int[n];
        boolean[] has = new boolean[N];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); int x = (int) in.nval;
            r[i] = x;
            has[x] = true;
        }
        Arrays.sort(r);
        int mx = r[n - 1];
        while (q-- > 0) {
            in.nextToken(); int mul = (int) in.nval;
            for (int x : r) {
                if (x * mul > mx) {
                    System.out.println("NO");
                    break;
                }
                if (has[x * mul]) {
                    System.out.println("YES");
                    break;
                }
            }
        }
    }
}
