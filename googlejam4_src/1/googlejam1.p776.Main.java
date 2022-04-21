package googlejam1.p776;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ahmad
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner input = new Scanner(new File("input.in"));
        PrintWriter out=new PrintWriter(new File("out"));
        int tc;
        tc = input.nextInt();
        for (int b = 1; b <= tc; b++) {
            int e, d = 0, x = 0, y = 0, z = 0;
            e = input.nextInt();
            int m[] = new int[e];

            for (int c = 0; c < e; c++) {
                m[c] = input.nextInt();

            }
            for (int c = 1; c < e; c++) {
                d = m[c - 1] - m[c];
                if (d >= y) {
                    y = d;
                }
                if (d >= 0) {
                    x += d;
                }
            }
            for (int c = 0; c < e - 1; c++) {
                if (m[c] <= y) {
                    z += m[c];
                }
                if (m[c] > y) {
                    z += y;
                }
            }
            out.printf("Case #%d: %d %d\n",b,x,z);
        }
        out.close();
    }

}

