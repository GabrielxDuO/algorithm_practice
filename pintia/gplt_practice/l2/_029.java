import java.util.*;
import java.io.*;

public class _029 {
    static final int N = 10010;
    static int l, r;
    static HashSet<Integer> vis = new HashSet<>();
    static HashSet<Integer> non = new HashSet<>();
    static int[] cnts = new int[N];
    static boolean[] ord = new boolean[N];

    static void check(int n) {
        if (non.contains(n) || ord[n]) return;
        vis.clear();
        int x = n;
        if (x == 1) cnts[x] = 1;
        while (x != 1) {
            vis.add(x);
            int y = 0;
            while (x != 0) {
                y += (x % 10) * (x % 10);
                x /= 10;
            }
            if (non.contains(y) || vis.contains(y)) {
                for (int z : vis) non.add(z);
                break;
            }
            if (y >= l && y <= r) ord[y] = true;
            cnts[n]++;
            x = y;
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int x = 2; x <= n / x; ++x) {
            if (n % x == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        in.nextToken();
        l = (int) in.nval;
        in.nextToken();
        r = (int) in.nval;
        for (int x = l; x <= r; ++x)
            check(x);
        boolean has = false;
        StringBuilder ans = new StringBuilder();
        for (int x = l; x <= r; ++x) {
            if (!non.contains(x) && !ord[x]) {
                ans.append(String.format("%d %d\n", x, cnts[x] * (1 + (isPrime(x) ? 1 : 0))));
                has = true;
            }
        }
        if (!has) ans.append("SAD\n");
        out.print(ans);
        out.flush();
        out.close();
    }
}
