import java.util.*;
import java.io.*;

public class _最大间隙 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int prev = 0, mx = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            int x = (int) in.nval;
            if (i > 0) mx = Math.max(mx, x - prev);
            prev = x;
        }
        System.out.println(mx);
    }
}
