import java.util.*;
import java.io.*;

public class E_组合数问题 {
    static int t, k;

    static long qmi(long base, long exp) {
        long res = 1L;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % k;
            base = (base * base) % k;
            exp >>= 1;
        }
        return res;
    }

    static int C(int n, int m) {
        long res = 1L;
        for (int a = n, b = 1; b <= m; --a, ++b) {
            res = res * a % k;
            res = res * qmi(b, k - 2) % k;
        }
        return (int) res;
    }

    static int lucas(long a, long b) {
        if (a < k && b < k) return C((int) a, (int) b);
        else return (int) (1L * C((int) (a % k), (int) (b % k)) * lucas(a / k, b / k) % k);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); t = (int) in.nval;
        in.nextToken(); k = (int) in.nval;
        while (t-- > 0) {
            in.nextToken(); int n = (int) in.nval;
            in.nextToken(); int m = (int) in.nval;
            int ans = 0;
            for (int i = 1; i <= n; ++i) {
                for (int j = 0; j <= Math.min(i, m); ++j) {
                    if (lucas(i, j) % k == 0) ++ans;
                }
            }
            System.out.println(ans);
        }
    }
}