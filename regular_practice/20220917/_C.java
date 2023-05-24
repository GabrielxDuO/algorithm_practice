import java.io.*;

public class _C {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int n = (int) in.nval;
        int col = m + n - 1;
        int offset = 0;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < col; ++j) {
                ans.append(j >= offset && j < offset + m ||
                    j >= col - offset - m && j < col - offset ? "*" : ".");
            }
            if (i < n / 2) ++offset;
            else --offset;
            ans.append("\n");
        }
        System.out.print(ans);
    }
}
