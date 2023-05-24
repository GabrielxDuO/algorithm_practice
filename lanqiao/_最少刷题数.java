import java.util.*;
import java.io.*;

public class _最少刷题数 {
    static int n;
    static int[] a, b;
    
    static int leftBound(int[] arr, int x) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + r >> 1;
            if (arr[m] >= x) r = m;
            else l = m + 1;
        }
        return l;
    }
    
    static boolean check(int m) {
        int smaller = leftBound(b, m), larger = n - leftBound(b, m + 1);
        return larger <= smaller;
    }
    
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        n = (int) in.nval;
        a = new int[n];
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            in.nextToken();
            int x = (int) in.nval;
            a[i] = x;
            if (x < l) l = x;
            if (x > r) r = x;
        }
        b = a.clone();
        Arrays.sort(b);
        while (l < r) {
            int m = l + r >> 1;
            if (check(m)) r = m;
            else l = m + 1;
        }
        int mid = l;
        int smaller = leftBound(b, mid), larger = n - leftBound(b, mid + 1);
        int offset = smaller == larger ? 1 : 0;
        for (int x : a) {
            if (x < mid) System.out.print((mid + offset - x) + " ");
            else System.out.print("0 ");
        }
    }
}