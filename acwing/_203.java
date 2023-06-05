import java.util.*;
import java.io.*;

public class _203 {
    static int x, y;

    static int exgcd(int a, int b) {
        if (b == 0) {
            x = 1; y = 0;
            return a;
        }
        int d = exgcd(b, a % b);
        int t = x;
        x = y;
        y = t - (a / b) * y;
        return d;
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt(), b = in.nextInt();
        exgcd(a, b);
        System.out.println((1L * x % b + b) % b);
    }
}
