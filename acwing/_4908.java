import java.util.*;
import java.io.*;

public class _4908 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long t = in.nextLong();
        long ans = 0L;
        long pd = 0L;
        long pb = 0;
        while (n-- > 0) {
            long d = in.nextLong();
            int b = in.nextInt();
            if (pd + pb <= d) {
                ans += pb;
                pb = b;
            } else {
                ans += d - pd;
                pb -= d - pd;
                pb += b;
            }
            pd = d;
        }
        if (pd + pb <= t) ans += pb;
        else ans += t - pd + 1;
        System.out.println(ans);
    }
}
