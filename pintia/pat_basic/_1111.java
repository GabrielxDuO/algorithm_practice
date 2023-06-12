import java.util.*;
import java.io.*;

public class _1111 {
    static Map<String, Integer> mp = new HashMap<>();
    static {
        mp.put("Jan", 1);
        mp.put("Feb", 2);
        mp.put("Mar", 3);
        mp.put("Apr", 4);
        mp.put("May", 5);
        mp.put("Jun", 6);
        mp.put("Jul", 7);
        mp.put("Aug", 8);
        mp.put("Sep", 9);
        mp.put("Oct", 10);
        mp.put("Nov", 11);
        mp.put("Dec", 12);
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        while (n-- > 0) {
            int mm = mp.get(in.next());
            String s = in.next();
            int dd = Integer.parseInt(s.substring(0, s.length() - 1));
            int yy = in.nextInt();
            String dt = String.format("%04d%02d%02d", yy, mm, dd);
            System.out.printf("%c %s\n", dt.equals(new StringBuilder(dt).reverse().toString()) ? 'Y' : 'N', dt);
        }
    }
}
