import java.util.*;
import java.io.*;

public class _翻硬币 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        char[] s = in.nextLine().toCharArray();
        char[] t = in.nextLine().toCharArray();
        int n = s.length, cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (s[i] != t[i]) {
                s[i + 1] = s[i + 1] == 'o' ? '*' : 'o';
                ++cnt;
            }
        }
        System.out.println(cnt);
    }
}
