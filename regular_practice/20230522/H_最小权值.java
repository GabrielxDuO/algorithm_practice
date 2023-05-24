import java.util.*;
import java.io.*;

public class H_最小权值 {
    public static void main(String[] args) throws IOException {
        long[] f = new long[2030];
        Arrays.fill(f, Long.MAX_VALUE);
        f[0] = 0L;
        for (int u = 1; u <= 2021; ++u) {
            for (int l = 0; l < u; ++l) {
                int r = u - l - 1;
                f[u] = Math.min(f[u], 1 + 2 * f[l] + 3 * f[r] + l * l * r);
            }
        }
        System.out.println(f[2021]);
    }
}
