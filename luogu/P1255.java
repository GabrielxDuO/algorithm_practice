import java.util.*;
import java.io.*;
import java.math.*;

public class P1255 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger[] f = new BigInteger[n + 1];
        f[1] = BigInteger.valueOf(1);
        if (n > 1) f[2] = BigInteger.valueOf(2);
        for (int i = 3; i <= n; ++i) {
            f[i] = f[i - 1].add(f[i - 2]);
        }
        System.out.println(f[n]);
    }
}
