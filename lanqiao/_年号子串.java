import java.util.*;
import java.io.*;

public class _年号子串 {
    public static void main(String[] args) throws IOException {
        int n = 2019;
        StringBuilder ans = new StringBuilder();
        while (n > 0) {
            if (n % 26 == 0) {
                ans.insert(0, 'Z');
                n = n / 26 - 1;
            } else {
                ans.insert(0, (char) (n % 26 - 1 + 'A'));
                n /= 26;
            }
        }
        System.out.println(ans);
    }
}
