import java.util.*;
import java.io.*;

public class _最大比例 {
    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int gcdSub(int a, int b) {
        if (a < b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        return b == 1 ? a : gcdSub(b, a / b);
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] x = new int[n], a = new int[n], b = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            x[i] = (int) in.nval;
        }
        Arrays.sort(x);
        int cnt = 0, fst = x[0];
        for (int i = 1; i < n; ++i) {
            if (x[i] != x[i - 1]) {
                int d = gcd(x[i], fst);
                a[cnt] = x[i] / d;
                b[cnt] = fst / d;
                ++cnt;
            }
        }
        int nume = a[0], deno = b[0];
        for (int i = 1; i < cnt; ++i) {
            nume = gcdSub(nume, a[i]);
            deno = gcdSub(deno, b[i]);
        }
        System.out.println(nume + "/" + deno);
    }
}
