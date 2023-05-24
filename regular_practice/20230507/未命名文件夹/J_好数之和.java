import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt(), r = in.nextInt();
        long sum = 0;
        outer: for (int x = Math.max(l, 2022); x <= r; ++x) {
            int t = x, len = 0;
            int[] ds = new int[10];
            while (t > 0) {
                ds[len++] = t % 10;
                t /= 10;
            }
            for (int i = 0; i < len - 3; ++i) {
                if (ds[i] == 2 && ds[i + 1] == 2 && ds[i + 2] == 0 && ds[i + 3] == 2) {
                    sum += x;
                    continue outer;
                }
            }
        }
        System.out.println(sum);
    }
}
