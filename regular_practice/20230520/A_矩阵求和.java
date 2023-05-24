import java.util.*;
import java.io.*;

public class A_矩阵求和 {
    static final int MOD = (int) 1e9 + 7;

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long ans = 0L;
        for (int i = 1; i <= n; ++i) {
            long half = 0L;
            for (int j = i + 1; j <= n; ++j) {
                half = (half + (long) Math.pow(gcd(i, j), 2)) % MOD;
            }
            ans = (((ans + half) % MOD + half) % MOD + i * i) % MOD;
        }
        System.out.println(ans);
    }
}
