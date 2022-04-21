package googlejam9.p114;

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
public class CodeJam3_B {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/Madi/codejam/B-small-practice.in"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Users/Madi/codejam/B-small-practice.out"))) {

            int t = Integer.parseInt(br.readLine());

            for (int i = 0; i < t; i++) {
                String[] s = br.readLine().split(" ");
                int b = Integer.parseInt(s[0]);
                long m = Long.parseLong(s[1]);
				int cs = i + 1;
                if (m > Math.pow(2, b - 2)) {
				    bw.write("Case #" + cs + ": IMPOSSIBLE");
				    bw.write("\n");
				    bw.flush();
				} else {
				
				    int pow = 0;
				    long res = 1;
				    while (pow < b - 2) {
				        res *= 2;
				        pow++;
				    }
				    res -= m;
				    ArrayList<Integer> list = new ArrayList<>();
				    while (res > 0) {
				        pow = 0;
				        long k = 1;
				        while (pow <= 50) {
				            if (k == res) {
				                list.add(pow + 1);
				                res = 0;
				                break;
				            } else if (k > res) {
				                list.add(pow);
				                res -= k / 2;
				                break;
				            }
				            k *= 2;
				            pow++;
				        }
				    }
				
				    bw.write("Case #" + cs + ": POSSIBLE\n");
				
				    for (int i1 = 0; i1 < b; i1++) {
				        for (int j = 0; j < b; j++) {
				            if (i1 >= j || (j == b - 1 && list.contains(i1))) {
				                bw.write("0");
				            } else {
				                bw.write("1");
				            }
				        }
				        bw.write("\n");
				    }
				    bw.flush();
				}
            }

        }

    }
}
