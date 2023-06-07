import java.util.*;
import java.io.*;

public class _100 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        long inc = 0L, dec = 0L;
        int prev = 0;
        for (int i = 1; i <= n; ++i) {
            in.nextToken(); int x = (int) in.nval;
            if (i >= 2) {
                int d = x - prev;
                if (d > 0) inc += d;
                else dec -= d;
            }
            prev = x;
        }
        System.out.println(Math.max(inc, dec));
        System.out.println(Math.abs(inc - dec) + 1);
    }
}
