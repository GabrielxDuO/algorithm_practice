import java.util.*;
import java.io.*;
import java.math.*;

public class _90 {
    static long slowMul(long a, long b, long p) {
        long c = 0L;
        while (b > 0) {
            if ((b & 1) != 0) c = (c + a) % p;
            a = (a + a) % p;
            b >>= 1;
        }
        return c;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        long a = in.nextLong(), b = in.nextLong(), p = in.nextLong();
        System.out.println(slowMul(a, b, p));
    }
}
