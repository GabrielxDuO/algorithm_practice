import java.util.*;
import java.io.*;

public class L_答疑 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        int[][] a = new int[n][3];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); a[i][0] = (int) in.nval;
            in.nextToken(); a[i][1] = (int) in.nval;
            in.nextToken(); a[i][2] = (int) in.nval;
        }
        Arrays.sort(a, (x, y) -> x[0] + x[1] + x[2] - (y[0] + y[1] + y[2]));
        long ans = 0, sum = 0;
        for (int[] b : a) {
            ans += sum + b[0] + b[1];
            sum += b[0] + b[1] + b[2];
        }
        System.out.println(ans);
    }
}
