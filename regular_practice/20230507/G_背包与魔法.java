import java.util.*;
import java.io.*;

public class G_背包与魔法 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), c = in.nextInt(), k = in.nextInt();
        int[][] f = new int[c + 1][2];
        for (int i = 0; i < n; ++i) {
            int v = in.nextInt(), w = in.nextInt();
            for (int j = c; j >= v; --j) {
                f[j][0] = Math.max(f[j][0], f[j - v][0] + w);
                f[j][1] = Math.max(Math.max(f[j][0], f[j][1]), f[j - v][1] + w); 
                if (v + k <= j) f[j][1] = Math.max(f[j][1], f[j - v - k][0] + w * 2);
            }
        }
        System.out.println(Math.max(f[c][0], f[c][1]));
    }
}
