import java.util.*;
import java.io.*;

public class _修改数组 {
    static final int N = (int) 1e6 + 10;
    static int[] roots = new int[N];

    static int find(int x) {
        return x == roots[x] ? x : (roots[x] = find(roots[x]));
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        for (int i = 1; i < N; ++i) roots[i] = i;
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            int x = (int) in.nval;
            x = find(x);
            System.out.print(x + " ");
            roots[x] = x + 1;
        }
    }
}
