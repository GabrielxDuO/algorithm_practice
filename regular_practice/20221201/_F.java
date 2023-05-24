import java.util.*;
import java.io.*;

public class _F {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[][] g = new int[m][n];
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                in.nextToken();
                g[j][n - i - 1] = (int) in.nval;
            }
        }
        for (int[] arr : g) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
            System.out.print("\n");
        }
    }
}
