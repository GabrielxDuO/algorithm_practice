import java.util.*;
import java.io.*;

public class R_质因数个数 {
    static int pf(long n) {
        int cnt = 0;
        for (long x = 2; x <= n / x; ++x) {
            if (n % x == 0) {
                while (n % x == 0) n /= x;
                ++cnt;
            }
        }
        if (n > 1) ++cnt;
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(pf(n));
    }
}
