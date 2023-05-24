import java.util.*;
import java.io.*;

public class _F {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(in.readLine());
        n /= 1000;
        System.out.printf("%02d:%02d:%02d", n / 3600 % 24, n / 60 % 60, n % 60);
    }
}
