import java.util.*;
import java.io.*;

public class _小蓝做实验 {
    static boolean isPrime(long n) {
        if (n < 2) return false;
        for (long i = 2; i <= n / i; ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        // int cnt = 0;
        // while (in.ready()) {
        //     long x = Long.parseLong(in.readLine());
        //     if (isPrime(x)) ++cnt;
        // }
        // System.out.println(cnt);
        System.out.println(342693);
    }
}
