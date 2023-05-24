import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int r = (int) in.nval;
        in.nextToken(); int q = (int) in.nval;
        int[][] a = new int[n * 2][3];
        for (int i = 0; i < n * 2; ++i) {
            a[i][0] = i + 1;
            in.nextToken(); a[i][1] = (int) in.nval;
        }
        for (int i = 0; i < n * 2; ++i) {
            in.nextToken(); a[i][2] = (int) in.nval;
        }
        Arrays.sort(a, (x, y) -> x[1] == y[1] ? x[0] - y[0] : y[1] - x[1]);
        while (r-- > 0) {
            for (int i = 0; i < n; ++i) {
                int x = i * 2, y = i * 2 + 1;
                if (a[x][2] > a[y][2]) ++a[x][1];
                else ++a[y][1];
            }
            Arrays.sort(a, (x, y) -> x[1] == y[1] ? x[0] - y[0] : y[1] - x[1]);
        }
        System.out.println(a[q - 1][0]);
    }
}
