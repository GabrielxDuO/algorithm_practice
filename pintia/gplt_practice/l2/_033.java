import java.util.*;
import java.io.*;

public class _033 {
    static int n;
    static int[] s1;
    static int t1, t2;
    static char[] s2;

    static int calc(int a, int b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        if (op == '/') return a / b;
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        in.nextToken(); n = (int) in.nval;
        s1 = new int[n + 1];
        s2 = new char[n + 1];
        for (int i = 0; i < n; ++i) {
            in.nextToken(); s1[++t1] = (int) in.nval;
        }
        String[] ss = br.readLine().split(" ");
        for (int i = 0; i < n - 1; ++i) s2[++t2] = ss[i].charAt(0);
        while (t1 > 1) {
            int n1 = s1[t1--], n2 = s1[t1--];
            char op = s2[t2--];
            if (op == '/' && n1 == 0) {
                System.out.printf("ERROR: %d/0\n", n2, n1);
                return;
            }
            s1[++t1] = calc(n2, n1, op);
        }
        System.out.printf("%d\n", s1[t1--]);
    }
}
