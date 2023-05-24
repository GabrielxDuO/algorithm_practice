import java.util.*;
import java.io.*;
import java.math.*;

public class _求阶乘 {
    static long count(long n) {
        long cnt = 0;
        while (n > 0) cnt += n /= 5;
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long k = Long.parseLong(in.readLine());
        long l = 0L, r = Long.MAX_VALUE;
        while (l < r) {
            long m = l + (r - l >> 1);
            if (count(m) >= k) r = m;
            else l = m + 1;
        }
        System.out.println(count(l) == k ? l : -1);
    }
}
