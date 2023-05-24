import java.util.*;
import java.io.*;

public class _成绩分析 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int sum = 0, mx = -1, mn = 101;
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            int x = (int) in.nval;
            if (x > mx) mx = x;
            if (x < mn) mn = x;
            sum += x;
        }
        System.out.printf("%d\n%d\n%.2f\n", mx, mn, sum * 1.0 / n);
    }
}
