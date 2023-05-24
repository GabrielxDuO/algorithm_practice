import java.util.*;
import java.io.*;

public class D_内存空间 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        int B = 0;
        while (t-- > 0) {
            String s = in.nextLine();
            String type = s.substring(0, s.indexOf(' '));
            int n = s.length();
            if (type.equals("int")) {
                for (char c : s.toCharArray()) {
                    if (c == '=') B += 4;
                }
            } else if (type.equals("long")) {
                for (char c : s.toCharArray()) {
                    if (c == '=') B += 8;
                }
            } else if (type.equals("String")) {
                int st = type.length() + 1;
                while (true) {
                    int l = s.indexOf('"', st);
                    if (l == -1) break;
                    int r = s.indexOf('"', l + 1);
                    B += r - l - 1;
                    st = r + 1;
                }
            } else if (type.equals("int[]")) {
                int st = type.length() + 1;
                while (true) {
                    int l = s.indexOf('[', st);
                    if (l == -1) break;
                    int r = s.indexOf(']', l + 1);
                    String len = s.substring(l + 1, r);
                    B += Integer.parseInt(len) * 4;
                    st = r + 1;
                }
            } else if (type.equals("long[]")) {
                int st = type.length() + 1;
                while (true) {
                    int l = s.indexOf('[', st);
                    if (l == -1) break;
                    int r = s.indexOf(']', l + 1);
                    String len = s.substring(l + 1, r);
                    B += Integer.parseInt(len) * 8;
                    st = r + 1;
                }
            }
        }
        int GB = B / (1024 * 1024 * 1024); B %= (1024 * 1024 * 1024);
        int MB = B / (1024 * 1024); B %= (1024 * 1024);
        int KB = B / 1024; B %= 1024;
        if (GB != 0) System.out.print(GB + "GB");
        if (MB != 0) System.out.print(MB + "MB");
        if (KB != 0) System.out.print(KB + "KB");
        if (B != 0) System.out.print(B + "B");
    }
}
