import java.util.*;
import java.io.*;

public class B_小蓝做实验 {
    static boolean isPrime(long n) {
        for (long x = 2L; x <= n / x; ++x) {
            if (n % x == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("primes.txt")));
        // int cnt = 0;
        // while (in.ready()) {
        //     long x = Long.parseLong(in.readLine());
        //     if (isPrime(x)) ++cnt;
        // }
        // System.out.println(cnt);
        System.out.println(342693);
    }
}
