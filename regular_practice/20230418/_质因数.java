import java.util.*;
import java.io.*;

public class _质因数 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        boolean fst = true;
        System.out.print(n + "=");
        for (int x = 2; x <= n / x; ++x) {
            if (n % x == 0) {
                while (n % x == 0) {
                    if (!fst) System.out.print("*");
                    else fst = false;
                    System.out.print(x);
                    n /= x;
                }
            }
        }
        if (n > 1) {
            if (!fst) System.out.print("*");
            System.out.print(n);
        }
    }
}
