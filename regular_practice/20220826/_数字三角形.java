import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class _数字三角形 {
    static int N, max = 0;
    static int[][] triangle;
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        N = (int) in.nval;
        triangle = new int[N][N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j <= i; ++j) {
                in.nextToken();
                triangle[i][j] = (int) in.nval;
            }
        }
        recursion(0, 0, 0);
        System.out.println(max);
    }
    
    static void recursion(int r, int c, int num) {
        if (c > r) return;
        num += triangle[r][c];
        if (r == N - 1) {
            max = Math.max(max, num);
            return;
        }
        recursion(r + 1, c, num);
        recursion(r + 1, c + 1, num);
    }
}
