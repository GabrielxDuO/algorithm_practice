import java.util.*;
import java.io.*;

public class A_小明的字符串 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        char[] s = in.nextLine().toCharArray();
        char[] t = in.nextLine().toCharArray();
        int n = s.length, m = t.length;
        int i = 0, j = 0, mx = 0;
        for (; i < n && j < m; ++i) {
            if (s[i] == t[j]) ++j;
            else {
                mx = Math.max(mx, j);
                j = s[i] == t[0] ? 1 : 0;
            }
        }
        mx = Math.max(mx, j);
        System.out.println(mx);
    }
}
