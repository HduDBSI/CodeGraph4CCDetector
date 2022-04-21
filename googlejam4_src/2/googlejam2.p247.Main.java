package googlejam2.p247;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
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
    static int memo[]=new int[1000010];
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Scanner input=new Scanner(new File("input.in"));
        int tc=input.nextInt();
        int n;
        Arrays.fill(memo, 1000000);
		            memo[1] = 1;
		
		for(int i1 = 1; i1 < 1000000; i1++) {
			StringBuffer nn=new StringBuffer(i1+"");
			nn=nn.reverse();
			int reverse = Integer.parseInt(nn.toString());
			memo[i1+1] = Math.min(memo[i1+1], memo[i1] + 1);
			memo[reverse] = Math.min(memo[reverse], memo[i1] + 1);
		           
		}
        for (int i = 0; i < tc; i++) {
            n=input.nextInt();
           
            System.out.printf("Case #%d: %d \n",(i+1),memo[n]);
        }
        
        
    }
}
