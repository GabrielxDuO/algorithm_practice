import java.io.*;

public class _金币 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int K = (int) in.nval;
        int count = 0, x = 1, i = 0;
        while (i < K) {
            for (int j = 0; j < x && i < K; ++j, ++i) count += x;
            ++x;
        }
        System.out.println(count);
    }
}
