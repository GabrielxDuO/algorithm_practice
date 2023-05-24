import java.util.*;
import java.io.*;

public class L_数位递增的数 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cnt = 0;
        outer: for (int i = 1; i <= n; ++i) {
            int x = i, prev = 9;
            while (x > 0) {
                int d = x % 10;
                if (d > prev) continue outer;
                prev = d;
                x /= 10;
            }
            ++cnt;
        }
        System.out.println(cnt);
    }
}
