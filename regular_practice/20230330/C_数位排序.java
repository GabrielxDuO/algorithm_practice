import java.util.*;
import java.io.*;

public class C_数位排序 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        int[][] a = new int[n][2];
        for (int i = 0; i < n; ++i) {
            int x = i + 1;
            a[i][0] = x;
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            a[i][1] = sum;
        }
        Arrays.sort(a, (x, y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
        System.out.println(a[m - 1][0]);
    }
}
