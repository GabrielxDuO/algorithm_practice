import java.util.*;
import java.io.*;

public class _平均 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        int[] mxs = new int[10];
        long ans = 0L;
        for (int i = 0; i < n; ++i) {
            in.nextToken(); int a = (int) in.nval;
            in.nextToken(); int b = (int) in.nval;
            mxs[a] = Math.max(mxs[a], b);
            ans += b;
        }
        for (int i = 0; i < 10; ++i) ans -= mxs[i];
        System.out.println(ans);
    }
}
