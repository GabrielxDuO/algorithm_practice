import java.util.*;
import java.io.*;

public class _卡牌 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        long m = (long) in.nval;
        int[] a = new int[n], b = new int[n];
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            b[i] = (int) in.nval;
        }
        int ans = 0;
        outer: while (true) {
            for (int i = 0; i < n; ++i) {
                if (a[i] != 0) --a[i];
                else {
                    if (b[i] != 0 && m != 0L) {
                        --b[i];
                        --m;
                    } else break outer;
                }
            }
            ++ans;
        }
        System.out.println(ans);
    }
}
