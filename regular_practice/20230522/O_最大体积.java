import java.util.*;
import java.io.*;

public class O_最大体积 {
    static final int C = (int) 1e7;

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean[] f = new boolean[C + 1];
        f[0] = true;
        for (int i = 0; i < n; ++i) {
            int v = in.nextInt();
            if (v == 1) {
                System.out.println("0");
                return;
            }
            for (int j = v; j <= C; ++j) {
                f[j] |= f[j - v];
            } 
        }
        for (int x = C; x >= 0; --x) {
            if (!f[x]) {
                System.out.println(x);
                return;
            }
        }
    }
}
