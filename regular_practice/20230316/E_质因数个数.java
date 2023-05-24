import java.util.*;
import java.io.*;

public class E_质因数个数 {
    static int pf(long n) {
        int cnt = 0;
        for (long i = 2; i <= n / i; ++i) {
            if (n % i == 0) {
                int s = 0;
                while (n % i == 0) n /= i;
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
