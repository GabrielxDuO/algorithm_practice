import java.util.*;
import java.io.*;

public class B_合数个数 {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int x = 2; x <= n / x; ++x) {
            if (n % x == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        for (int i = 1; i <= 2020; ++i) {
            if (!isPrime(i)) ++cnt;
        }
        System.out.println(cnt); // 1714
    }
}
