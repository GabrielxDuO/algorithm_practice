import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();
        int mx = 0, cnt = 1;
        for (int i = 1; i < n; ++i) {
            if (a[i] > a[i - 1]) ++cnt;
            else {
                mx = Math.max(mx, cnt);
                cnt = 1;
            }
        }
        System.out.println(mx);
    }
}
