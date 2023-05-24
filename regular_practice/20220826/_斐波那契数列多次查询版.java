import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class _斐波那契数列多次查询版 {
    static int[] rec = new int[40];
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int T = (int) in.nval;
        while (T-- > 0) {
            in.nextToken();
            System.out.println(fibonacci((int) in.nval));
        }
    }

    static int fibonacci(int n) {
        if (n <= 1) return n;
        if (rec[n] != 0) return rec[n];
        else return rec[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }
}
