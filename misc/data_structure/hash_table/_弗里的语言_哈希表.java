import java.util.StringTokenizer;
import java.io.*;

public class _弗里的语言_哈希表 {
    static class SimpleHashTable {
        static int B = 131, H = (int) 1e6 - 17;
        String[] values = new String[H];
        String[] overflowValues = new String[H];
        int overflowSize = 0;

        int hash(String str) {
            int sum = 0;
            for (char ch : str.toCharArray()) {
                sum = sum * B % H + (ch - 'a' + 1) % H;
            }
            return (sum + H) % H;
        }

        boolean add(String str) {
            int idx = hash(str);
            if (values[idx] == null) {
                values[idx] = str;
                return true;
            } else if (str.equals(values[idx])) return false;
            else {
                for (int i = 0; i < overflowSize; ++i) {
                    if (str.equals(overflowValues[i])) return false;
                }
                overflowValues[overflowSize++] = str;
                return true;
            }
        }

        boolean has(String str) {
            int idx = hash(str);
            if (values[idx] == null) return false;
            else if (str.equals(values[idx])) return true;
            else {
                for (int i = 0; i < overflowSize; ++i) {
                    if (str.equals(overflowValues[i])) return true;
                }
                return false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(Reader.next());
        SimpleHashTable hashTable = new SimpleHashTable();
        while (N-- > 0) {
            String str = Reader.next();
            if (!hashTable.add(str)) {
                System.out.println(str);
                return;
            }
        }
        System.out.println("NO");
    }

    static class Reader {
        static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
        static StringTokenizer st = new StringTokenizer("");

        static String next() throws IOException {
            while (!st.hasMoreTokens()) {
                st = new StringTokenizer(BR.readLine());
            }
            return st.nextToken();
        }

        static String nextLine() throws IOException {
            return BR.readLine();
        }
    }
}