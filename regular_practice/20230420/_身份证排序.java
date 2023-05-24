import java.util.*;
import java.io.*;

public class _身份证排序 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String[] a = new String[n];
        for (int i = 0; i < n; ++i) a[i] = in.readLine();
        Arrays.sort(a, (x, y) -> {
            int cmp = y.substring(6, 14).compareTo(x.substring(6, 14));
            return cmp == 0 ? y.compareTo(x) : cmp;
        });
        for (String id : a) System.out.println(id);
    }
}
