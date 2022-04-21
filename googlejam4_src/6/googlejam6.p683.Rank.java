package googlejam6.p683;
import java.util.*;
import java.io.*;
import java.lang.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Rank{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int f=1;f<=t;f++)
        {
            int n=s.nextInt();
            //int[] arr=new int[(2*n-1)*3];
            int[] arr1=new int[2501];
            
            int len=(2*n-1)*n;
            for(int i=0;i<len;i++)
            {             
                arr1[s.nextInt()]++;
            }
            System.out.print("Case #"+f+": ");
            for(int i=0;i<2501;i++)
            {
                if(arr1[i]%2!=0)
                    System.out.print(i+" ");
            }
            System.out.println();
        }
        
    }
    
}
