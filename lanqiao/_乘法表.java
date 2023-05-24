import java.util.*;
import java.io.*;

public class P2354 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int p = (int) in.nval;
        for (int i = 1; i < p; ++i) {
            for (int j = 1; j <= i; ++j) {
                System.out.printf("%s*%s=%s ", 
                    Integer.toString(i, p).toUpperCase(),
                    Integer.toString(j, p).toUpperCase(),
                    Integer.toString(i * j, p).toUpperCase());
            }
            System.out.println();
        }
    }
}
