import java.util.*;
import java.io.*;

public class _K倍区间 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        long[] s = new long[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken();
            s[i] = s[i - 1] + (int) in.nval;
        }
        int[] cnts = new int[k];
        ++cnts[0];
        long cnt = 0;
        for (int i = 1; i <= n; ++i) {
            cnt += cnts[(int) (s[i] % k)]++;
        }
        System.out.println(cnt);
    }
}
