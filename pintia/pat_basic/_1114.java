import java.util.*;
import java.io.*;

public class _1114 {
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int x = 2; x <= n / x; ++x) {
            if (n % x == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String n = in.next();
        boolean allPrime = true;
        while (!n.isEmpty()) {
            int x = Integer.parseInt(n);
            boolean isp = isPrime(x);
            if (!isp) allPrime = false;
            System.out.printf("%s %s\n", n, isp ? "Yes" : "No");
            n = n.substring(1);
        }
        if (allPrime) System.out.println("All Prime!");
        
    }
}
