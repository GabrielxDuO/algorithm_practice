import java.util.*;
import java.io.*;

public class F_字串排序 {
    static void sort(String s) {
        char[] a = s.toCharArray();
        int n = a.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = 0; j < n - 1; ++j) {
                if (a[j] > a[j + 1]) {
                    char t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    ++cnt;
                }
            }
        }
        System.out.println(String.valueOf(s));
        System.out.println(cnt);
    }
    
    public static void main(String[] args) throws IOException {
        String s = "";
        for (int i = 25; i >= 0; --i) s = s + (char) (i + 'a') + (char) (i + 'a');
        sort(s);
        System.out.println(s);
    }
}
