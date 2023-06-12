import java.util.*;
import java.io.*;

public class _1112 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int t = (int) in.nval;
        int st = 0, mx = 0;
        boolean exceed = false, has = false;
        for (int i = 0; i < n; ++i) {
            in.nextToken(); int x = (int) in.nval;
            mx = Math.max(mx, x);
            if (x <= t && exceed) {
                System.out.printf("[%d, %d]\n", st, i - 1);
                exceed = false;
            } else {
                if (x > t && !exceed) {
                    st = i;
                    exceed = has = true;
                }
            }
        }
        if (exceed) System.out.printf("[%d, %d]\n", st, n - 1);
        if (!has) System.out.printf("%d\n", mx);
    }
}
