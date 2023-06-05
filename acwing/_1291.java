import java.util.*;
import java.io.*;

public class _1291 {
    static final int N = (int) 1e6 + 10;
    static int[] cnts = new int[N];
    static int[] s = new int[N];

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); a[i] = (int) in.nval;
            ++cnts[a[i]];
        }
        for (int i = 1; i < N; ++i) {
            for (int j = i; j < N; j += i) {
                // 反向求: i是哪些j的约数
                s[j] += cnts[i];
            }
        }
        for (int x : a) System.out.println(s[x] - 1);
    }
}
