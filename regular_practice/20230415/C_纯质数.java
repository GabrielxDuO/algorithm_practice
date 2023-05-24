import java.util.*;
import java.io.*;

public class C_纯质数 {
    static boolean isPrime(int n) {
        for (int x = 2; x <= n / x; ++x) {
            if (n % x == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        // int cnt = 0;
        // outer: for (int i = 1; i <= 20210605; ++i) {
        //     int x = i;
        //     while (x > 0) {
        //         int d = x % 10;
        //         if (d != 2 && d != 3 && d != 5 && d != 7) continue outer;
        //         x /= 10;
        //     }
        //     if (!isPrime(i)) continue;
        //     ++cnt;
        // }
        // System.out.println(cnt);
        System.out.println(1903);
    }
}
