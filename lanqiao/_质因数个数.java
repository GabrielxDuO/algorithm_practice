import java.util.*;
import java.io.*;

public class _质因数个数 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());
        int cnt = 0;
        for (int i = 2; i <= n / i; ++i) {
            if (n % i == 0) {
                while (n % i == 0) n /= i;
                ++cnt;
            }
        }
        if (n > 1) ++cnt;
        System.out.println(cnt);
    }
}
