import java.util.*;
import java.io.*;

public class _字符统计 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] s = in.readLine().toCharArray();
        int[] cnts = new int[26];
        int mx = 0;
        for (char c : s) {
            if (++cnts[c - 'A'] > mx) mx = cnts[c - 'A'];
        }
        for (int i = 0; i < 26; ++i) {
            if (cnts[i] == mx) System.out.print((char) (i + 'A'));
        }
    }
}
