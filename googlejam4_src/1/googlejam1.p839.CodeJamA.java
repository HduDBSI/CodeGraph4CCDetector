package googlejam1.p839;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class CodeJamA {

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("A-large.in"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        for (int XXX = 0; XXX < T; XXX++) {
            bf.readLine();
            int X[];
            String data[] = bf.readLine().split(" ");
            X = new int[data.length];
            int prev = Integer.parseInt(data[0]);
            X[0] = prev;
            int A = 0;
            int B = 0;
            int dif = 0;
            int Z = 0;
            for (int i = 1; i < data.length; i++) {
                X[i] = Integer.parseInt(data[i]);
                if (prev > X[i]) {
                    dif = prev - X[i];
                    A += dif;
                    if (dif > Z) {
                        Z = dif;
                    }
                }
                prev = X[i];
            }

            B = 0;
            for (int i = 0; i < data.length - 1; i++) {
                if (X[i] <= Z) {
                    B += X[i];
                } else {
                    B += Z;
                }
            }

            System.out.printf("Case #%d: %d %d\n", XXX + 1, A, B);
        }

    }

}
