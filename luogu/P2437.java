import java.util.*;
import java.io.*;
import java.math.*;

public class P2437 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();
        int x = n - m;
        BigInteger[] f = new BigInteger[x + 1];
        f[0] = f[1] = BigInteger.valueOf(1);
        for (int i = 2; i <= x; ++i) {
            f[i] = f[i - 1].add(f[i - 2]);
        }
        System.out.println(f[x]);
    }
}
