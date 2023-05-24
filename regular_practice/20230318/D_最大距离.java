import java.util.*;
import java.io.*;

public class D_最大距离 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();
        int mx = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                mx = Math.max(mx, Math.abs(i - j) + Math.abs(a[i] - a[j]));
            }
        }
        System.out.println(mx);
    }
}
