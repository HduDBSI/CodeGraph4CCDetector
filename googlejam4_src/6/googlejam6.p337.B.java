package googlejam6.p337;

import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author bartosz
 */
public class B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            int n = in.nextInt();
            int[] ar = new int[2501];
            for(int j=0;j<2*n-1;j++){
                for(int k=0;k<n;k++)
                    ar[in.nextInt()]++;
            }
            int[] ans = new int[n];
            int count=0;
            for(int j=1;j<2501;j++){
                //System.out.println(ar[j]);
                if(ar[j]!=0 && ar[j]%2!=0){
                    ans[count]=j;
                    count++;
                }
            }
            Arrays.sort(ans);
            System.out.print("Case #"+(i+1)+": ");
            for(int j=0;j<n;j++)
                System.out.print(ans[j]+" ");
            System.out.println();
        
        }
        
    }
    
}
