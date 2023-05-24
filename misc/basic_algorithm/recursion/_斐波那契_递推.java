import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class _斐波那契_递推 {
    public static void main(String[] args) throws IOException {
        BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(BR);
        in.nextToken();
        int M = (int) in.nval;
        while (M-- > 0) {
            in.nextToken();
            int N = (int) in.nval;
            System.out.println(fibonacci(N - 1));
        }
    }

    static int fibonacci(int n) {
        return n <= 2 ? n : fibonacci(n - 1) + fibonacci(n - 2);
    }
}
