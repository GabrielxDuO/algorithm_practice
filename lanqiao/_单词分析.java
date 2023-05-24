import java.util.*;
import java.io.*;

public class _单词分析 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int[] cnts = new int[26];
        int mx = 0;
        char mxChar = '\0';
        for (char c : s.toCharArray()) {
            int cnt = ++cnts[c - 'a'];
            if (cnt > mx || cnt == mx && c < mxChar) {
                mx = cnt;
                mxChar = c;
            }
        }
        System.out.println(mxChar + "\n" + mx);
    }
}
