import java.util.*;
import java.io.*;

public class _求解质因子 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());
        for (long i = 2L; i <= n / i; ++i) {
            if (n % i == 0) {
                System.out.print(i + " ");
                while (n % i == 0) n /= i;
            }
        }
        if (n > 1) System.out.println(n);
    }
}
