import java.util.*;
import java.io.*;

public class _方块与收纳盒 {
    static final int N = 90;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int t = (int) in.nval;
        while (t-- > 0) {
            in.nextToken(); int n = (int) in.nval;
            long[] f = new long[N];
            f[1] = 1L; f[2] = 2L;
            for (int i = 3; i <= n; ++i) {
                f[i] = f[i - 1] + f[i - 2];
            }
            System.out.println(f[n]);
        }
    }
}
