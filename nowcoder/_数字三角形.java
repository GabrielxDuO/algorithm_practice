import java.util.*;
import java.io.*;

public class _数字三角形 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int n = (int) in.nval;
        int x = 1;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= i; ++j) {
                System.out.printf("%4d", x++);
            }
            System.out.println();
        }
    }
}
