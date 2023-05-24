import java.util.*;
import java.io.*;

public class D_小明的背包1 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int c = (int) in.nval;
        int[] f = new int[c + 1];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); int v = (int) in.nval;
            in.nextToken(); int w = (int) in.nval;
            for (int j = c; j >= v; --j) {
                f[j] = Math.max(f[j], f[j - v] + w);
            }
        }
        System.out.println(f[c]);
    }
}
