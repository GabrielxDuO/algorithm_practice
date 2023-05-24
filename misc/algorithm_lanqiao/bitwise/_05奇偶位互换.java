import java.util.*;
import java.io.*;

public class _05奇偶位互换 {
    static final int A = 0b10101010101010101010101010101010;
    static final int B = 0b01010101010101010101010101010101;

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken();
        int n = (int) in.nval;
        int oddBits = n & A;
        int evenBits = n & B;
        System.out.println((oddBits >> 1) ^ (evenBits << 1));
    }
}
