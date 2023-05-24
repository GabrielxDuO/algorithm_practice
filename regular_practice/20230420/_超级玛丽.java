import java.util.*;
import java.io.*;

public class _超级玛丽 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] f = new int[n + 1];
        boolean[] forbid = new boolean[n + 1];
        while (m-- > 0) {
            int x = in.nextInt();
            if (x <= n) forbid[x] = true;
        }
        if (!forbid[2]) f[2] = 1;
        if (!forbid[3]) f[3] = f[2] + 1;
        for (int i = 4; i <= n; ++i) {
            if (!forbid[i]) f[i] = f[i - 1] + f[i - 2];
        }
        System.out.println(f[n]);
    }
}
