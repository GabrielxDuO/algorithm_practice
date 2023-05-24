import java.util.*;
import java.io.*;

public class _开心的金明 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        int[] f = new int[n + 1];
        for (int i = 0; i < m; ++i) {
            in.nextToken(); int v = (int) in.nval;
            in.nextToken(); int p = (int) in.nval;
            for (int j = n; j >= v; --j) {
                f[j] = Math.max(f[j], f[j - v] + v * p);
            }
        }
        System.out.println(f[n]);
    }
}
