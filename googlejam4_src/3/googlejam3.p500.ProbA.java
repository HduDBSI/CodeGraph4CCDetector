package googlejam3.p500;

import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mainak
 */
public class ProbA {
    public static void main(String[] arg) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i =1; i <= t; i++) {
            int r = s.nextInt();
            int c = s.nextInt();
            int w = s.nextInt();
            int ans = (c-1)/w + w;
            System.out.println("Case #" + i +": " + ans);
        }
    }
}
