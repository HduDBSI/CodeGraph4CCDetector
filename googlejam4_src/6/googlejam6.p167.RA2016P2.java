package googlejam6.p167;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Madi
 */
public class RA2016P2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:/Projects/AdExtractor/src/codejam/B-small-practice.in"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:/Projects/AdExtractor/src/codejam/B-small-practice.out"));

        int t = Integer.parseInt(br.readLine());
        for (int x = 0; x < t; x++) {
            int n = Integer.parseInt(br.readLine());
            int[] cnt = new int[2501];
            for (int i = 0; i < 2 * n - 1; i++) {
                String[] s = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    cnt[Integer.parseInt(s[j])]++;
                }
            }
            
            int[] res = new int[n];
            int j = 0;
            for (int i = 0; i < 2501; i++) {
                if (cnt[i] % 2 != 0 && j < n) {
                    res[j] = i;
                    j++;
                }
            }
            bw.write("Case #" + (x + 1) + ": ");
            for (int i = 0; i < n; i++) {
                bw.write(res[i] + " "); 
            }
            bw.write("\n"); 
            bw.flush();
        }

    }
}
