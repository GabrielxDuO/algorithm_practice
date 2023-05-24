import java.util.*;
import java.io.*;

public class _钟表 {
    public static void main(String[] args) throws IOException {
        for (int hh = 0; hh < 12; ++hh) {
            for (int mm = 0; mm < 60; ++mm) {
                for (int ss = 0; ss < 60; ++ss) {
                    if (hh == 0 && mm == 0 && ss == 0) continue;
                    double sd = 360 * ss / 60;
                    double md = 360 * mm / 60 + sd / 60;
                    double hd = 360 * hh / 12 + md / 12;
                    double A = Math.abs(hd - md), B = Math.abs(md - sd);
                    A = Math.min(A, 360 - A);
                    B = Math.min(B, 360 - B);
                    if (A == 2 * B) {
                        System.out.println(hh + " " + mm + " " + ss);
                        return;
                    } 
                }
            }
        }
    }
}