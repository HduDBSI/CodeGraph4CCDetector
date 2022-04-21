package googlejam7.p170;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Madi
 */
public class CodeJam2_B {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Madi/codejam/B-small-practice.in"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Madi/codejam/B-small-practice.out"))) {

            int t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                String[] s = br.readLine().split(" ");
				String s1 = s[0];
				String s2 = s[1];
                int n = s1.length();
				int x = (int) Math.pow(10, n - 1);
				int y = (int) Math.pow(10, n);
				
				String a;
				String b;
				
				int min = Integer.MAX_VALUE;
				int minSum = Integer.MAX_VALUE;
				int minb = Integer.MAX_VALUE;
				int mina = Integer.MAX_VALUE;
				
				for (int i1 = 0; i1 < y; i1++) {
				    for (int j = 0; j < y; j++) {
				        a = String.valueOf(i1);
				        while (a.length() < n) {
				            a = "0" + a;
				        }
				        b = String.valueOf(j);
				        while (b.length() < n) {
				            b = "0" + b;
				        }
				        boolean eq = true;
				        for (int k = 0; k < n; k++) {
				            if (s1.charAt(k) != '?' && s1.charAt(k) != a.charAt(k)) {
				                eq = false;
				                break;
				            }
				        }
				
				        if (eq) {
				            for (int k = 0; k < n; k++) {
				                if (s2.charAt(k) != '?' && s2.charAt(k) != b.charAt(k)) {
				                    eq = false;
				                    break;
				                }
				            }
				        }
				
				        if (eq) {
				            if (min > Math.abs(i1 - j)) {
				                min = Math.abs(i1 - j);
				                minSum = i1 + j;
				                mina = i1;
				                minb = j;
				            } else if (min == Math.abs(i1 - j)) {
				                if (minSum > i1 + j) {
				                    minSum = i1 + j;
				                    mina = i1;
				                    minb = j;
				                } else if (minSum == i1 + j) {
				                    if (minb > j) {
				                        minb = j;
				                        mina = i1;
				                    }
				                }
				            }
				        }
				    }
				}
				a = String.valueOf(mina);
				b = String.valueOf(minb);
				while (a.length() < n) {
				    a = "0" + a;
				}
				
				while (b.length() < n) {
				    b = "0" + b;
				}
				
				bw.write("Case #" + (i + 1) + ": ");
				bw.write(a + " " + b);
				bw.write("\n");
				bw.flush();
            }

        }

    }
}
