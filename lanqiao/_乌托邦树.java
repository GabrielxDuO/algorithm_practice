import java.util.*;
import java.io.*;
import java.math.*;

public class _乌托邦树 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        BigInteger h = new BigInteger("1");
        for (int i = 1; i <= n; ++i){
            if ((i & 1) == 0) h = h.add(BigInteger.ONE);
            else h = h.shiftLeft(1);
        }
        System.out.println(h);
    }
}
