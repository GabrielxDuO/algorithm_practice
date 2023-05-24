import java.util.*;
import java.io.*;
import java.math.*;

public class _六六大顺 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            a.append("10");
            b.append('2');
        }
        a.append('0');
        b.append('0');
        String ans = new BigInteger(a.toString()).subtract(new BigInteger(b.toString()))
            .add(BigInteger.valueOf(n)).multiply(BigInteger.valueOf(4))
            .divide(BigInteger.valueOf(9)).toString();
        PrintWriter pw = new PrintWriter(System.out);
        pw.println(ans);
        pw.flush();
        pw.close();
    }
}
