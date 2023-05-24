import java.util.*;
import java.io.*;

public class _百亿富翁 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            in.nextToken();
            a[i] = (int) in.nval;
        }
        int[] stk = new int[n + 1];
        int top = 0;
        for (int i = 1; i <= n; ++i) {
            while (top > 0 && a[stk[top]] <= a[i]) --top;
            System.out.print(top == 0 ? "-1 " : stk[top] + " ");
            stk[++top] = i;
        }
        System.out.print("\n");
        top = 0;
        int[] tmp = new int[n + 1];
        for (int i = n; i >= 1; --i) {
            while (top > 0 && a[stk[top]] <= a[i]) --top;
            tmp[i] = top == 0 ? -1 : stk[top];
            stk[++top] = i;
        }
        for (int i = 1; i <= n; ++i) System.out.print(tmp[i] + " ");
    }
}
