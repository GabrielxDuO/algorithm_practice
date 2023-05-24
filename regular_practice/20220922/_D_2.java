import java.io.*;

public class _D_2 {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); 
        int n = (int) in.nval;
        int[] arr = new int[10];
        for (int i = 1; i <= n; ++i) {
            ++arr[0];
            boolean carry = false;
            if (arr[0] == 27) {
                carry = true;
                arr[0] = 1;
                for (int j = 1; j < 10 && carry; ++j) {
                    ++arr[j];
                    if (arr[j] == 27) arr[j] = 1;
                    else carry = false;
                }
            }
        }
        for (int i = 9; i >= 0; --i) {
            if (arr[i] > 0) {
                System.out.print((char) (arr[i] - 1 + 'A'));
            }
        }
        System.out.println();
    }
}
