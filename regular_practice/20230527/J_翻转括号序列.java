import java.util.*;
import java.io.*;

public class J_翻转括号序列 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken(); int n = (int) in.nval;
        in.nextToken(); int m = (int) in.nval;
        char[] s = ('\0' + br.readLine()).toCharArray();
        while (m-- > 0) {
            in.nextToken(); int op = (int) in.nval;
            in.nextToken(); int l = (int) in.nval;
            if (op == 1) {
                in.nextToken(); int r = (int) in.nval;
                for (int i = l; i <= r; ++i) s[i] = s[i] == '(' ? ')' : '(';
            } else {
                int lc = 0, rc = 0, mx = 0;
                for (int i = l; i <= n; ++i) {
                    if (s[i] == '(') ++lc;
                    else ++rc;
                    if (rc > lc) break;
                    if (lc == rc) mx = Math.max(mx, i);
                }
                System.out.println(mx);
            }
        }
    }
}
