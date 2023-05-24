import java.util.*;
import java.io.*;

public class _巧克力 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int x = (int) in.nval;
        in.nextToken();
        int n = (int) in.nval;
        int[][] a = new int[n][3];
        for (int i = 1; i <= n; ++i) {
            in.nextToken();
            a[i][0] = (int) in.nval;
            in.nextToken();
            a[i][1] = (int) in.nval;
            in.nextToken();
            a[i][2] = (int) in.nval;
        }
        Arrays.sort(a, (x, y) -> x[1] - y[1]);
        for (int i = x; i >= 0; --i) {
            
        }
    }
}
