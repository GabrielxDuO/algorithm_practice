import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int t = (int) in.nval;
        outer: while (t-- > 0) {
            in.nextToken(); int n = (int) in.nval;
            in.nextToken(); int m = (int) in.nval;
            for (int x = 1; x <= m; ++x) {
                if (n % x != x - 1) {
                    System.out.println("Yes");
                    continue outer;
                }
            }
            System.out.println("No");
        }
    }
}
